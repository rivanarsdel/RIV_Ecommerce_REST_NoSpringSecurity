package dev.riv.REST_TurboBasic.modelHelpers;

import dev.riv.REST_TurboBasic.models.User;
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
@Table(name = "user_address")

public class UserAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @Column(name="address_hash")
    String addressHash;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name="user_hash")
    String linkedUserHash;
    @Column(name="shipping_address")
    String shippingAddress;
    @Column(name="billing_address")
    String billingAddress;
}
