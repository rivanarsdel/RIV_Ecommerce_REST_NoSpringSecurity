package dev.riv.REST_TurboBasic.modelHelpers;

import dev.riv.REST_TurboBasic.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_image")
public class ProductImage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Product.class)
    @JoinColumn(name="product_hash")
    String linkedProductHash;
    @Column(name = "image_name")
    String imageName;
    @Column(name = "encoded_image")
    String encodedImage;
}
