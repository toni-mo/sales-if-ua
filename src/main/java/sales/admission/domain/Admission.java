package sales.admission.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import sales.users.domain.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Myroslav on 14.08.2015.
 */

@Entity
@Table(name = "Admission")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "shop", referencedColumnName = "id")
    @JsonIgnore
    private User shop;

    @Column(name = "sum")
    @JsonProperty("sum")
    private double sum;

    @Column(name = "paymentId")
    @JsonProperty("paymentId")
    private String paymentId;

    @Column(name = "date")
    @JsonProperty("date")
    private Date date;

    @PrePersist
    private void onCreateAdmissionInstance() {
        date = new Date();
    }

    public Admission() {
    }

    public Admission(User shop, double sum, String paymentId) {
        this.shop = shop;
        this.sum = sum;
        this.paymentId = paymentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getShop() {
        return shop;
    }

    public void setShop(User shop) {
        this.shop = shop;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
}
