package sales.paypal.controller;

import com.paypal.api.payments.CreditCard;
import com.paypal.core.rest.PayPalRESTException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sales.goods.domain.Good;
import sales.paypal.service.Authentication;
import sales.paypal.service.PaymentService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by volodya on 27.07.15.
 */
@RestController
@RequestMapping("/paypal")
public class PaypalController {

    protected static Logger logger = Logger.getLogger(PaypalController.class.getName());

//    @RequestMapping(value = "/payment",
//            method = RequestMethod.POST,
//            produces = "application/json; charset=UTF-8",
//            consumes = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String makePayment(@RequestBody List<Good> goods) throws IOException, PayPalRESTException {
//        logger.info("Payment: make payment");
//        CreditCard creditCard = new CreditCard();
//        creditCard.setNumber("4032034269731629");
//        creditCard.setType("visa");
//        creditCard.setExpireMonth("08");
//        creditCard.setExpireYear("2020");
//        creditCard.setCvv2("874");
//        creditCard.setFirstName("Ok");
//        creditCard.setLastName("Okovuch");
//        PaymentService service = new PaymentService(new Authentication().getAuthenticationTocken());
//        service.setCard(creditCard);
//        service.addGoods(goods);
//        return service.makePayment();
//    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = "application/json; charset=UTF-8",
            consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveApi(@RequestParam(value = "clientId") String clientId,
                          @RequestParam(value = "secret") String secret)throws PayPalRESTException {
        logger.info("Paypal: save paypal api");
        String token = new Authentication().getAuthenticationToken(clientId, secret);
        return token;
    }

}
