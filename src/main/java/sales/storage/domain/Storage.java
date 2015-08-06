package sales.storage.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import sales.goods.domain.Good;
import sales.users.domain.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by volodya on 05.08.15.
 */
@Entity
@Table(name = "storage")
public class Storage implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private long id;

    @Column
    @JsonProperty
    private double price;

    @Column
    @JsonProperty
    private int quantity;

    @ManyToOne(targetEntity = Good.class)
    @JoinColumn(name = "good", referencedColumnName = "id")
    @JsonProperty
    private Good good;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user", referencedColumnName = "id")
    @JsonProperty
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", good=" + good.toString() +
                ", user=" + user.toString() +
                '}';
    }
}
