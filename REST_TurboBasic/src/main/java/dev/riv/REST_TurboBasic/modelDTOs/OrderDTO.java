package dev.riv.REST_TurboBasic.modelDTOs;

import dev.riv.REST_TurboBasic.models.Product;

import java.util.List;

public class OrderDTO {

//     todo extract lists into table
     double customerPayment;
     List<Product> productList;
     List<Integer> productQuantities;
     List<Double> priceModifiers;

     public OrderDTO() {
     }

     public OrderDTO(double customerPayment, List<Product> productList, List<Integer> productQuantities, List<Double> priceModifiers) {
          this.customerPayment = customerPayment;
          this.productList = productList;
          this.productQuantities = productQuantities;
          this.priceModifiers = priceModifiers;
     }

     public double getCustomerPayment() {
          return customerPayment;
     }

     public void setCustomerPayment(double customerPayment) {
          this.customerPayment = customerPayment;
     }

     public List<Product> getProductList() {
          return productList;
     }

     public void setProductList(List<Product> productList) {
          this.productList = productList;
     }

     public List<Integer> getProductQuantities() {
          return productQuantities;
     }

     public void setProductQuantities(List<Integer> productQuantities) {
          this.productQuantities = productQuantities;
     }

     public List<Double> getPriceModifiers() {
          return priceModifiers;
     }

     public void setPriceModifiers(List<Double> priceModifiers) {
          this.priceModifiers = priceModifiers;
     }
}
