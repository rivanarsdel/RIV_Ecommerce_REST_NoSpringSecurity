package dev.riv.REST_TurboBasic.modelDTOs;

import dev.riv.REST_TurboBasic.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDTO {

     int orderId;
     String orderHash;
     String linkedUserHash;
     String linkedAddressHash;
     double customerPayment;
     List<Product> productList;
     List<Integer> productQuantities;

     // Were we to want discounts, we could create an additional "helper" model productDiscounts which contains a name & modifier
}
