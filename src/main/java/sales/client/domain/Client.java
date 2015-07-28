package sales.client.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "clients")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Long id;

    @Column(name = "first_name")
    @JsonProperty
    private String firstName;

    @Column(name = "last_name")
    @JsonProperty
    private String lastName;

    @Column(name = "sex")
    @JsonProperty
    private String sex;

    @Column(name = "born_date")
    @JsonProperty
    private Date bornDate;

    @Column(name = "email")
    @JsonProperty
    private String email;

    @Column(name = "phone")
    @JsonProperty
    private String phone;

    @Column(name = "pasword")
    @JsonProperty
    private String pasword;

    public Client() {
    }

    public Client(Long id, String firstName, String lastName, String sex, Date bornDate, String email, String phone, String pasword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.bornDate = bornDate;
        this.email = email;
        this.phone = phone;
        this.pasword = pasword;
    }

    @Override
    public String toString() {
        return String.format
                ("Client [id=%d, firstName='%s', lastName='%s', sex='%s', bornDate='%tD', email='%s', phone='%s'];",
                        id, firstName, lastName, sex, bornDate, email, phone);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
}






