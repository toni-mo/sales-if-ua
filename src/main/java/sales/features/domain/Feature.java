package sales.features.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by volodya on 24.07.15.
 */
@Entity
@Table(name = "features")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Feature implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @Column(name = "name", columnDefinition = "VARCHAR(255) COLLATE utf8_general_ci")
    @JsonProperty("name")
    private String name;

    @Column(name = "type", columnDefinition = "VARCHAR(255) COLLATE utf8_general_ci")
    @JsonProperty("type")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
