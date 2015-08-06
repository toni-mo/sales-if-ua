package sales.payment.dto.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import sales.payment.creaditCard.domain.CreditCard;

import java.util.List;

/**
 * Created by volodya on 29.07.15.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AnonymMultyPaymentDTO {

    @JsonProperty
    private List<Long> goodsId;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String email;

    @JsonProperty
    private CreditCard card;

    public List<Long> getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(List<Long> goodId) {
        this.goodsId = goodId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "AnonymMultyPaymentDTO{" +
                "goodsId=" + goodsId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", card=" + card.toString() +
                '}';
    }
}
