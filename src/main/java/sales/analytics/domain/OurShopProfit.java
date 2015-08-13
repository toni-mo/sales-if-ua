package sales.analytics.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Myroslav on 13.08.2015.
 */
@Entity
@Table(name = "ourProfit")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class OurShopProfit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @Column(name = "profit")
    @JsonProperty("profit")
    private int profit;

    @Column(name = "date")
    @JsonProperty("date")
    private Date date;

    public OurShopProfit() {
    }

    public OurShopProfit(int profit, Date date) {
        this.profit = profit;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
