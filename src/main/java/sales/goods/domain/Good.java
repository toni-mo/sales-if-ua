package sales.goods.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "goods")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Good implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "description")
    @JsonProperty("description")
    private String description;

    @Column(name = "amount")
    @JsonProperty("amount")
    private int amount;

    @Column(name = "price")
    @JsonProperty("price")
    private int price;

    public Good() {
    }

    @JsonCreator
    public Good(GoodsBuilder builder) {
        this.id = builder.getId();
        this.name = builder.getName();
        this.description = builder.getDescription();
        this.amount = builder.getAmount();
        this.price = builder.getPrice();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }


    public static class GoodsBuilder {

        private int id;

        private String name;

        private String description;

        private int amount;

        private int price;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getAmount() {
            return amount;
        }

        public int getPrice() {
            return price;
        }

        public GoodsBuilder id(int id) {
            this.id = id;
            return this;

        }

        public GoodsBuilder name(String name) {
            this.name = name;
            return this;

        }

        public GoodsBuilder description(String description) {
            this.description = description;
            return this;

        }

        public GoodsBuilder amount(int amount) {
            this.amount = amount;
            return this;

        }

        public GoodsBuilder price(int price) {
            this.price = price;
            return this;

        }

        public Good build() {
            return new Good(this);
        }
    }

}
