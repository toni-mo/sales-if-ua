package sales.payment.dto.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import sales.payment.creaditCard.domain.CreditCard;

/**
 * Created by taras on 14.08.15.
 */
public class ServicePaymentDTO {

    @JsonProperty
    private long cardId;

    @JsonProperty
    private CreditCard card;

    @JsonProperty
    private long userId;

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
