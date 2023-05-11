package dev.riv.REST_TurboBasic.models;

import dev.riv.REST_TurboBasic.modelHelpers.UserAddress;

import javax.persistence.*;

// <><><><><>|| Inclusions & Requirement Definitions ||<><><><><> \\
/*
Relevant helper models:
OrderPriceModifier
OrderProductQuantity
*/
@Entity
@Table(name = "ecommerce_order")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "order_hash", nullable = false)
    String orderHash;
//    @Column(name = "orderDate")
//    long orderDate;

//    Relation to User
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_hash")
    String linkedUserHash;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserAddress.class)
    @JoinColumn(name = "address_hash")
    String linkedAddressHash;

//    Invoice Block
    @Column(name = "price_total", nullable = false)
    double priceTotal;
    @Column(name = "customer_payment", nullable = false)
    double customerPayment;
    @Column(name = "dollar_deficit", nullable = false)
    double dollarDeficit;

//    Boiler Plate


    public Order() {
    }

    public Order(int id, String orderHash, String linkedUserHash, String linkedAddressHash, double priceTotal, double customerPayment, double dollarDeficit) {
        this.id = id;
        this.orderHash = orderHash;
        this.linkedUserHash = linkedUserHash;
        this.linkedAddressHash = linkedAddressHash;
        this.priceTotal = priceTotal;
        this.customerPayment = customerPayment;
        this.dollarDeficit = dollarDeficit;
    }

//Getters

    public int getId() {
        return id;
    }

    public String getOrderHash() {
        return orderHash;
    }

    public String getLinkedUserHash() {
        return linkedUserHash;
    }

    public String getLinkedAddressHash() {
        return linkedAddressHash;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public double getCustomerPayment() {
        return customerPayment;
    }

    public double getDollarDeficit() {
        return dollarDeficit;
    }

//    Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderHash(String orderHash) {
        this.orderHash = orderHash;
    }

    public void setLinkedUserHash(String linkedUserHash) {
        this.linkedUserHash = linkedUserHash;
    }

    public void setLinkedAddressHash(String linkedAddressHash) {
        this.linkedAddressHash = linkedAddressHash;
    }

    public void setPriceTotal(double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public void setCustomerPayment(double customerPayment) {
        this.customerPayment = customerPayment;
    }

    public void setDollarDeficit(double dollarDeficit) {
        this.dollarDeficit = dollarDeficit;
    }
}
