package sales.category.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by taras on 11.08.15.
 */
@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    @JsonProperty
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="category", fetch = FetchType.EAGER)
    @JsonProperty
    private List<SubCategory> subCategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
