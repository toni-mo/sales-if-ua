package sales.payment.paymentHandler;

import com.paypal.api.payments.CreditCard;
import sales.goods.domain.Good;
import sales.payment.paypal.domain.Paypal;
import sales.storage.domain.Storage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodya on 03.08.15.
 */
public class Transaction {

    private CreditCard card;

    private Paypal paypal;

    private List<Storage> storages;

    private String paymentId;

    public Transaction() {
        storages = new ArrayList<Storage>();
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

    public List<Storage> getStorages() {
        return storages;
    }

    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }

    public double getTotalAmont()
    {
        double sum = 0;
        for(Storage storage : this.storages)
        {
            sum += storage.getPrice();
        }
        return sum;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "card=" + card.toString() +
                ", paypal=" + paypal.toString() +
                ", goodList=" + storages.toString() +
                '}';
    }
}
