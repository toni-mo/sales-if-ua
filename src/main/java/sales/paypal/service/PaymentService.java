package sales.paypal.service;

import com.paypal.api.payments.*;
import com.paypal.core.rest.PayPalRESTException;
import sales.goods.domain.Good;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by volodya on 26.07.15.
 */
public class PaymentService {

    private CreditCard card;

    private String accessToken;

    private List<Transaction> transactions;

    public PaymentService(String accessToken) {
        this.accessToken = accessToken;
        transactions = new ArrayList<Transaction>();
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public void addGoods(List<Good> goods) {
        Transaction transaction = new Transaction();
        transaction.setDescription("creating a payment");
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(String.format(Locale.US, "%.2f", countTotal(goods)));
        transaction.setAmount(amount);
        transactions.add(transaction);
    }

    private double countTotal(List<Good> goods) {
        double sum = 0;
        for (Good good : goods) {
            sum += good.getPrice();
        }
        return sum;
    }

    public String makePayment() throws PayPalRESTException {
        FundingInstrument fundingInstrument = new FundingInstrument();
        fundingInstrument.setCreditCard(card);

        List<FundingInstrument> fundingInstruments = new ArrayList<FundingInstrument>();
        fundingInstruments.add(fundingInstrument);

        Payer payer = new Payer();
        payer.setFundingInstruments(fundingInstruments);
        payer.setPaymentMethod("credit_card");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(this.transactions);

        Payment createdPayment = payment.create(accessToken);

        return createdPayment.toString();
    }

    public List<Link> executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = Payment.get(accessToken, paymentId);
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment newPayment = payment.execute(accessToken, paymentExecution);

        return newPayment.getLinks();
    }


}
