package dev.riv.REST_TurboBasic.modelDTOs;

public class ProductDTO {
    int productId;
    String productHash;
    String productName;
    String description;
    double price;

//    Boilerplate


    public ProductDTO() {
    }

    public ProductDTO(int productId, String productHash, String productName, String description, double price) {
        this.productId = productId;
        this.productHash = productHash;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductHash() {
        return productHash;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductHash(String productHash) {
        this.productHash = productHash;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
