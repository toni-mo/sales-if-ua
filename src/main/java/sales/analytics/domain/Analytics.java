package sales.analytics.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Myroslav on 29.07.2015.
 */

@Entity
@Table(name = "daily_stats")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)

public class Analytics {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    /**
     * Quantity of products sales for a day
     */
    @Column(name = "soldGoods")
    @JsonProperty("soldGoods")
    private int soldGoods;

    /**
     * The total cost of product sold
     */
    @Column(name = "cost")
    @JsonProperty("cost")
    private double cost;

    /**
     * Amount of users who have registered for a day
     */
    @Column(name = "usersAmount")
    @JsonProperty("usersAmount")
    private int usersAmount;

    /**
     * Amount of users who have registered for a day
     */
    @Column(name = "shopsAmount")
    @JsonProperty("shopsAmount")
    private int shopsAmount;

    @Column(name = "date")
    @JsonProperty("date")
    private Date date;

    public Analytics() {
    }

    public Analytics(int soldGoods, double cost, int usersAmount, int shopsAmount, Date date) {
        this.soldGoods = soldGoods;
        this.cost = cost;
        this.usersAmount = usersAmount;
        this.shopsAmount = shopsAmount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoldGoods() {
        return soldGoods;
    }

    public void setSoldGoods(int soldGoods) {
        this.soldGoods = soldGoods;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getUsersAmount() {
        return usersAmount;
    }

    public void setUsersAmount(int usersAmount) {
        this.usersAmount = usersAmount;
    }

    public int getShopsAmount() {
        return shopsAmount;
    }

    public void setShopsAmount(int shopsAmount) {
        this.shopsAmount = shopsAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
