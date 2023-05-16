package dev.riv.REST_TurboBasic.modelDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {

    // Product
    int productId;
    String productHash;
    String productName;
    String description;
    double price;

    // ProductImage
    int productImageId;
    String imageHash;
    String linkedProductHash;
    String imageName;
    String encodedImage;
}
