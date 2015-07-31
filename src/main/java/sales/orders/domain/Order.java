package sales.orders.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Myroslav on 23.07.2015.
 */

@Entity
@Table(name = "orders")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)


public class Order implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @Column(name = "shop_id")
    @JsonProperty("shopId")
    private int shopId;

    @Column(name = "buyer_id")
    @JsonProperty("buyerId")
    private int buyerId;

    @Column(name = "goods_id")
    @JsonProperty("goodsId")
    private int goodsId;

    @Column(name = "amount")
    @JsonProperty("amount")
    private int amount;

    @Column(name = "price")
    @JsonProperty("price")
    private int price;


    @Column(name = "date")
    @JsonProperty("date")
    private Date date;

    public Order() {
    }

    public Order(int shopId, int buyerId, int goodsId, int amount, int price, Date date) {
        this.shopId = shopId;
        this.buyerId = buyerId;
        this.goodsId = goodsId;
        this.amount = amount;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
