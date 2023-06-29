package dev.riv.REST_TurboBasic.modelDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class WishlistDTO {

    int id;
    String wishlistHash;
    String linkedUserHash;
    String name;
    String description;

    //Helper Model Fields
    int wishlistProductId;
    String linkedWishlistHash;
    String productHash;
}
