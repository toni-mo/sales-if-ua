package sales.payment.paypal.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import sales.users.domain.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by volodya on 28.07.15.
 */
@Entity
@Table(name = "paypal")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Paypal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private long id;

    @Column
    @JsonProperty
    private String clientId;

    @Column(name = "secret")
    @JsonProperty
    private String secret;

    @Column(name = "userId")
    @JsonIgnore
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Paypal{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", secret='" + secret + '\'' +
                ", userId=" + userId +
                '}';
    }
}
