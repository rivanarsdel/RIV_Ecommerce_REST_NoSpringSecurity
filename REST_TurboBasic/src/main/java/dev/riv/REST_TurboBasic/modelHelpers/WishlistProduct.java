package dev.riv.REST_TurboBasic.modelHelpers;

import dev.riv.REST_TurboBasic.models.Wishlist;
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
@Table(name = "wishlist_product")

public class WishlistProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Wishlist.class)
    @JoinColumn(name = "wishlist_hash")
    String linkedWishlistHash;
    @Column(name = "product_hash")
    String productHash;
}
