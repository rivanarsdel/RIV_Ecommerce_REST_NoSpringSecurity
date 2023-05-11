package dev.riv.REST_TurboBasic.models;

//<><><><><>|| Requirements Definition ||<><><><><>\\
// We could include more than just a description for products, like tech specs

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
Relevant Helper Models
WishlistProduct
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "wishlist")

public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name="wishlist_hash",nullable = false)
    String wishlistHash;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "user_hash")
    String linkedUserHash;

//    Customization Utility
    @Column(name = "name")
    String name;
    @Column(name = "description")
    String description;
}
