package dev.riv.REST_TurboBasic.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//<><><><><>|| Requirements Definition ||<><><><><>\\
// We could include more than just a description for products, like tech specs
/*
Relevant Helper Models:
ProductImage
*/
@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int productId;
    @Column(name = "product_hash", nullable = false)
    String productHash;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "description", nullable = false)
    String description;
    @Column(name = "Price", nullable = false)
    double price;

}
