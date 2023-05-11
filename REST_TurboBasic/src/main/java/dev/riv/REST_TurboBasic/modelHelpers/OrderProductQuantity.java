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
@Table(name = "order_product_quantity")

public class OrderProductQuantity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Order.class)
    @JoinColumn(name = "order_hash", nullable = false)
    String orderHash;

    @Column(name="ordered_product_hash", nullable = false)
    String productHash;
    @Column(name="ordered_product_quantity", nullable = false)
    int productQuantity;
}
