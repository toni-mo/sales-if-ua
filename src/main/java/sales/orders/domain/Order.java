package sales.orders.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import sales.storage.domain.Storage;
import sales.users.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Volodya on 23.07.2015.
 */

@Entity
@Table(name = "orders")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)


public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user", referencedColumnName = "id")
    @JsonProperty
    private User user;

    @ManyToOne(targetEntity = Storage.class)
    @JoinColumn(name = "storage", referencedColumnName = "id")
    @JsonProperty
    private Storage storage;

    @Column
    private String paymentId;

    @Column
    private Date date;

    public Order() {
    }

    public Order(User user, Storage storage, String paymentId) {
        this.user = user;
        this.storage = storage;
        this.date = new Date();
        this.paymentId = paymentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", storage=" + storage.toString() +
                '}';
    }
}
