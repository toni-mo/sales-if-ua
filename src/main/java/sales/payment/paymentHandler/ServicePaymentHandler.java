package sales.payment.paymentHandler;

import com.paypal.api.payments.CreditCard;
import com.paypal.core.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sales.admission.domain.Admission;
import sales.admission.service.AdmissionService;
import sales.orders.domain.Order;
import sales.orders.services.OrdersService;
import sales.payment.creaditCard.service.CreaditCardService;
import sales.payment.dto.data.AnonymMultyPaymentDTO;
import sales.payment.dto.data.ServicePaymentDTO;
import sales.payment.paypal.service.Authentication;
import sales.payment.paypal.service.PayPalPayment;
import sales.payment.paypal.service.PaypalService;
import sales.roles.service.RoleService;
import sales.storage.domain.Storage;
import sales.storage.service.StorageService;
import sales.users.domain.User;
import sales.users.service.UserService;
import sales.util.Constants;

import java.util.*;

/**
 * Created by taras on 14.08.15.
 */
@Component
public class ServicePaymentHandler {
    protected static Logger logger = LoggerFactory.getLogger(ServicePaymentHandler.class.getName());

    @Autowired
    private CreaditCardService creaditCardService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private PaypalService paypalService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdmissionService admissionService;

    private CreditCard card;

    private Transaction transaction;

    private void setCard(sales.payment.creaditCard.domain.CreditCard card) {
        this.card = new CreditCard();
        this.card.setNumber(card.getNumber());
        this.card.setType(card.getType());
        this.card.setExpireMonth(card.getExpireMonth());
        this.card.setExpireYear(card.getExpireYear());
        this.card.setNumber(card.getNumber());
        this.card.setCvv2(card.getCvv2());
    }

    private void setCard(long creditCardId) {
        sales.payment.creaditCard.domain.CreditCard card = creaditCardService.get(creditCardId);
        this.card = new CreditCard();
        this.card.setNumber(card.getNumber());
        this.card.setType(card.getType());
        this.card.setExpireMonth(card.getExpireMonth());
        this.card.setExpireYear(card.getExpireYear());
        this.card.setNumber(card.getNumber());
        this.card.setCvv2(card.getCvv2());
    }

    public CreditCard getCard() {
        return card;
    }

    private void defineTransaction(CreditCard card) {
        transaction = new Transaction();
        transaction.setPaypal(paypalService.getByUserId(userService.getByEmail(Constants.OUR_EMAIL).getId()));
        transaction.setCard(card);
    }

    public void servicePayment(ServicePaymentDTO servicePaymentDTO) throws PayPalRESTException {
        this.preparePayment(servicePaymentDTO);
        this.callPayPal();
        this.saveServicePayment(servicePaymentDTO.getUserId(), this.transaction);
    }

    private void preparePayment(ServicePaymentDTO servicePaymentDTO) {
        if (servicePaymentDTO.getCard().equals(null)) {
            setCard(servicePaymentDTO.getCard());
        } else {
            setCard(servicePaymentDTO.getCardId());
        }
        defineTransaction(this.card);
    }

    private void callPayPal() throws PayPalRESTException {
            PayPalPayment payment = new PayPalPayment(Authentication.
                    getAuthenticationToken(transaction.getPaypal().getClientId(),
                            transaction.getPaypal().getSecret()));
            payment.prepareCard(transaction.getCard());
            payment.prepareTransaction(transaction.getTotalAmont());
            transaction.setPaymentId(payment.makePayment());
    }

    private void saveServicePayment(long userId,Transaction transaction) {
        saveTransaction(userService.getById(userId), transaction.getTotalAmont(), transaction.getPaymentId());
    }

    private void saveTransaction(User user, double money, String paymentId) {
        Admission admission = new Admission(user, money, paymentId);
        admissionService.add(admission);
    }
}
