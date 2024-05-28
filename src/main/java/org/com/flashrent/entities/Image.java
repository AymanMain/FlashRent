package org.com.flashrent.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

@Setter
@Getter
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "propriete_id")
    private Propriete propriete;

    public Image() {}

    public Image(byte[] image) {
        this.image = image;
    }
    public String getImageBase64() {
        if (image != null) {
            return Base64.encodeBase64String(image);
        }
        return null;
    }
}