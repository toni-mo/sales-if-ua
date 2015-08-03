package sales.payment.paymentHandler;

import com.paypal.api.payments.CreditCard;
import sales.goods.domain.Good;
import sales.payment.paypal.domain.Paypal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodya on 03.08.15.
 */
public class Transaction {

    private CreditCard card;

    private Paypal paypal;

    private List<Good> goodList;

    public Transaction() {
        goodList = new ArrayList<Good>();
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public Paypal getPaypal() {
        return paypal;
    }

    public void setPaypal(Paypal paypal) {
        this.paypal = paypal;
    }

    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }

    public double getTotalAmont()
    {
        double sum = 0;
        for(Good good : this.goodList)
        {
            sum += good.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "card=" + card.toString() +
                ", paypal=" + paypal.toString() +
                ", goodList=" + goodList +
                '}';
    }
}
