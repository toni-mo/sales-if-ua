package sales.images.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import sales.images.repository.ImageRepository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "images")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Image implements Serializable {

    @Transient
    @JsonIgnore
    @Autowired
    private ImageRepository imageRepository;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "goodId")
    private int goodId;

    @Lob
    @Column(name = "image", nullable = false, columnDefinition = "mediumblob")
    private byte[] image;

    @Column(name = "chain")
    private int chain;

    public Image() {}

    public Image(int goodId, byte[] image, int chain) {
        this.goodId = goodId;
        this.image = image;
        this.chain = chain;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getChain() {
        return chain;
    }

    public void setChain(int chain) {
        this.chain = chain;
    }

}
