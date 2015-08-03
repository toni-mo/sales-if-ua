package sales.payment.paypal.service;

import com.paypal.api.payments.*;
import com.paypal.core.rest.PayPalRESTException;
import sales.goods.domain.Good;
import sales.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by volodya on 26.07.15.
 */
public class PayPalPayment {

    private String accessToken;

    private List<Transaction> transactions;

    private Payer payer;

    public PayPalPayment(String accessToken) {
        this.accessToken = accessToken;
        transactions = new ArrayList<Transaction>();
    }

    public String makePayment() throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setIntent(Constants.PAYPAL_INTENT);
        payment.setPayer(payer);
        payment.setTransactions(this.transactions);

        Payment createdPayment = payment.create(accessToken);
        return createdPayment.getId();
    }

    public void prepareCard(CreditCard card) {
        this.createPayer(
                createFundingInstruments(createFundingInstrument(card)));
    }

    public void prepareTransaction(double totalAmount) {
        Transaction transaction = new Transaction();
        transaction.setDescription("creating a payment");
        transaction.setAmount(this.createAmount(totalAmount));
        transactions.add(transaction);
    }

    private void createPayer(List<FundingInstrument> instruments) {
        payer = new Payer();
        payer.setFundingInstruments(instruments);
        payer.setPaymentMethod(Constants.PAYPAL_PAYMENT_METHOD);
    }

    private FundingInstrument createFundingInstrument(CreditCard card) {
        FundingInstrument fundingInstrument = new FundingInstrument();
        fundingInstrument.setCreditCard(card);
        return fundingInstrument;
    }

    private List<FundingInstrument> createFundingInstruments(FundingInstrument fundingInstrument) {
        List<FundingInstrument> fundingInstruments = new ArrayList<FundingInstrument>();
        fundingInstruments.add(fundingInstrument);
        return fundingInstruments;
    }

    private Amount createAmount(double totalAmount) {
        Amount amount = new Amount();
        amount.setCurrency(Constants.CURRENCY);
        amount.setTotal(String.format(Locale.US, "%.2f", totalAmount));
        return amount;
    }
}
