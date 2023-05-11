package dev.riv.REST_TurboBasic.modelHelpers;

import dev.riv.REST_TurboBasic.models.ShoppingCart;
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
@Table(name = "shoppingcart_product")
public class ShoppingCartProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = ShoppingCart.class)
    @JoinColumn(name = "shopping_cart_hash")
    String linkedShoppingCart;
    @Column(name = "product_hash")
    String linkedProductHash;
    @Column(name = "quantity")
    int quantity;
}
