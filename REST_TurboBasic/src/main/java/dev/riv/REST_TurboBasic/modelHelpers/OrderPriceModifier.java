package dev.riv.REST_TurboBasic.modelHelpers;

import dev.riv.REST_TurboBasic.models.Order;
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
@Table(name = "order_price_modifier")

public class OrderPriceModifier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Order.class)
    @JoinColumn(name = "order_hash")
    String orderHash;
    @Column(name = "modifier_name", nullable = false)
    String priceModifierName;
    @Column(name = "customer_payment", nullable = false)
    double priceModifier;
}
