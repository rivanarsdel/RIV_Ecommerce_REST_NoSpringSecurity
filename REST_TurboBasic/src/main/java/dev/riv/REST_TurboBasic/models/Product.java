package dev.riv.REST_TurboBasic.models;

import javax.persistence.*;

//<><><><><>|| Requirements Definition ||<><><><><>\\
// We could include more than just a description for products, like tech specs
/*
Relevant Helper Models:
ProductImageList
*/
@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "product_hash", nullable = false)
    String productHash;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "description", nullable = false)
    String description;
    @Column(name = "Price", nullable = false)
    double price;
//Boilerplate

    public Product() {
    }

    public Product(int id, String productHash, String name, String description, double price) {
        this.id = id;
        this.productHash = productHash;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProductHash() {
        return productHash;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductHash(String productHash) {
        this.productHash = productHash;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
