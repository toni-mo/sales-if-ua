package sales.paypal.service;


import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.PayPalRESTException;
import com.paypal.core.rest.PayPalResource;

import java.io.File;

/**
 * Created by volodya on 25.07.15.
 */
public class Authentication {

    public String getAuthenticationTocken(String clientId, String secret) throws PayPalRESTException {
        PayPalResource.initConfig(new File(".",
                "src/main/resources/sdk_config.properties"));
        return new OAuthTokenCredential(clientId, secret)
                .getAccessToken();
    }

}
