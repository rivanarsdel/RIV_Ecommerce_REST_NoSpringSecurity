package dev.riv.REST_TurboBasic.models;

import dev.riv.REST_TurboBasic.modelHelpers.UserAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

// <><><><><>|| Inclusions & Requirement Definitions ||<><><><><> \\
/*
Relevant helper models:
OrderPriceModifier
OrderProductQuantity
*/
@Entity
@Table(name = "ecommerce_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int orderId;
    @Column(name = "order_hash", nullable = false)
    String orderHash;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_hash")
    String linkedUserHash;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserAddress.class)
    @JoinColumn(name = "address_hash")
    String linkedAddressHash;

//    Invoice Block
    @Column(name = "customer_payment", nullable = false)
    double customerPayment; //The only non-calculated value in this block
    @Column(name = "price_total", nullable = false)
    double priceTotal;
    @Column(name = "dollar_deficit", nullable = false)
    double dollarDeficit;
}
