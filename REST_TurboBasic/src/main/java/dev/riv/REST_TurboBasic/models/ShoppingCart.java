package dev.riv.REST_TurboBasic.models;

//<><><><><>|| Requirements Definition ||<><><><><>\\
// We could include more than just a description for products, like tech specs

import javax.persistence.*;

@Entity
@Table(name = "shopping_cart")

public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "shopping_cart_hash")
    String shoppingCartHash;
    @OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_hash")
    String linkedUserHash;
    @Column(name = "price")
    double shoppingCartPrice;

    public ShoppingCart(int id, String shoppingCartHash, String linkedUserHash, double shoppingCartPrice) {
        this.id = id;
        this.shoppingCartHash = shoppingCartHash;
        this.linkedUserHash = linkedUserHash;
        this.shoppingCartPrice = shoppingCartPrice;
    }

    public ShoppingCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoppingCartHash() {
        return shoppingCartHash;
    }

    public void setShoppingCartHash(String shoppingCartHash) {
        this.shoppingCartHash = shoppingCartHash;
    }

    public String getLinkedUserHash() {
        return linkedUserHash;
    }

    public void setLinkedUserHash(String linkedUserHash) {
        this.linkedUserHash = linkedUserHash;
    }

    public double getShoppingCartPrice() {
        return shoppingCartPrice;
    }

    public void setShoppingCartPrice(double shoppingCartPrice) {
        this.shoppingCartPrice = shoppingCartPrice;
    }
}

/*
Relevant Helper Models:
ShoppingCartProduct
*/
