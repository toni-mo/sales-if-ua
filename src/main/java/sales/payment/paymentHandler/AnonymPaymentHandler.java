package sales.payment.paymentHandler;

import com.paypal.api.payments.CreditCard;
import com.paypal.core.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sales.goods.domain.Good;
import sales.goods.service.GoodsService;
import sales.payment.dto.data.AnonymMultyPaymentDTO;
import sales.payment.paypal.service.Authentication;
import sales.payment.paypal.service.PayPalPayment;
import sales.payment.paypal.service.PaypalService;
import sales.users.domain.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by volodya on 30.07.15.
 */
@Component
public class AnonymPaymentHandler {

    @Autowired
    @Qualifier("goodsServiceSecond")
    private GoodsService goodsService;

    @Autowired
    private PaypalService paypalService;

    protected static Logger logger = Logger.getLogger(AnonymPaymentHandler.class.getName());

    private CreditCard card;

    private  Set<User> users;

    private List<Good> goods;

    private List<Transaction> transactions;


    private void setCard(sales.payment.creaditCard.domain.CreditCard card,
                        String firstName, String lastName) {
        this.card = new CreditCard();
        this.card.setNumber(card.getNumber());
        this.card.setType(card.getType());
        this.card.setExpireMonth(card.getExpireMonth());
        this.card.setExpireYear(card.getExpireYear());
        this.card.setNumber(card.getNumber());
        this.card.setCvv2(card.getCvv2());
        this.card.setFirstName(firstName);
        this.card.setLastName(lastName);
    }

    public CreditCard getCard() {
        return card;
    }

    private void getUsersByGoodsId(List<Long> ids)
    {
        users = new HashSet<User>();
        for(Long id : ids) {
            users.add(goodsService.get(id).getUser());
        }
    }

    private void getGoods(List<Long> ids)
    {
        goods = new ArrayList<Good>();
        for(Long id : ids) {
            goods.add(goodsService.get(id));
        }
    }

    private void defineTransactions(CreditCard card)
    {
        transactions = new ArrayList<Transaction>();
        for (User user : this.users)
        {
            Transaction transaction = new Transaction();
            for (Good good : this.goods)
            {
                if(user.equals(good.getUser())) {transaction.getGoodList().add(good);}
            }
            transaction.setPaypal(paypalService.get(user.getId()));
            transaction.setCard(card);
            transactions.add(transaction);
        }
    }

    public void anonymPayment(AnonymMultyPaymentDTO paymentDTO) throws PayPalRESTException {
        setCard(paymentDTO.getCard(), paymentDTO.getFirstName(), paymentDTO.getLastName());
        this.getUsersByGoodsId(paymentDTO.getGoodsId());
        this.getGoods(paymentDTO.getGoodsId());
        defineTransactions(this.card);
        payment();
    }

    private void payment() throws PayPalRESTException {
        for (Transaction transaction : this.transactions) {
            PayPalPayment payment = new PayPalPayment(Authentication.
                    getAuthenticationToken(transaction.getPaypal().getClientId(),
                            transaction.getPaypal().getSecret()));
            payment.prepareCard(transaction.getCard());
            payment.prepareTransaction(transaction.getTotalAmont());
            payment.makePayment();
        }
    }

}
