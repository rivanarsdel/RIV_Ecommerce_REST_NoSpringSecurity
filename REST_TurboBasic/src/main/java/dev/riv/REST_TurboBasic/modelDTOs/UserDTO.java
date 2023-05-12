package dev.riv.REST_TurboBasic.modelDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    int userId;
    String userHash;
    String displayName;
    String profilePicture;
    String email;
    String password;
    String role;
    double dollarBalance;

//  Helper Model Fields
    int addressId;
    String addressHash;
    String linkedUserHash;
    String billingAddress;
    String shippingAddress;
}
