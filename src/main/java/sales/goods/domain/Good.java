package sales.goods.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import sales.descriptions.domain.Description;
import sales.storage.domain.Storage;
import sales.users.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "goods")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Good implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private long id;

    @Column(name = "name", columnDefinition = "VARCHAR(255) COLLATE utf8_general_ci")
    @JsonProperty("name")
    private String name;

    @Column(name = "maker", columnDefinition = "VARCHAR(255) COLLATE utf8_general_ci")
    @JsonProperty
    private String maker;

    @Column
    @JsonProperty
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id", referencedColumnName = "id")
    @JsonProperty
    private List<Description> description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "good", referencedColumnName = "id")
    @JsonIgnore
    private List<Storage> storages;

    @JsonCreator
    public Good() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", date=" + date +
                ", description=" + description +
                ", storages=" + storages +
                '}';
    }
}
