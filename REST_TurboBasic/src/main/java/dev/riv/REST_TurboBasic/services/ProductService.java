package dev.riv.REST_TurboBasic.services;

import dev.riv.REST_TurboBasic.utilities.HashGenerator;
import dev.riv.REST_TurboBasic.modelDTOs.ProductDTO;
import dev.riv.REST_TurboBasic.models.Product;
import dev.riv.REST_TurboBasic.repositories.ProductRepository;
import dev.riv.REST_TurboBasic.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private HashGenerator hashGenerator;

    @Autowired
    public ProductService (ProductRepository productRepository, ProductImageRepository productImageRepository, HashGenerator hashGenerator) {
        this.productRepository = productRepository;
        this.productImageRepository = productImageRepository;
        this.hashGenerator = new HashGenerator();
    }

    public Product createProduct(ProductDTO productDto) throws NoSuchAlgorithmException {

        Product newProduct = new Product(
                productDto.getProductId(),
                productDto.getProductHash(),
                productDto.getProductName(),
                productDto.getDescription(),
                productDto.getPrice()
        );

        return productRepository.save(newProduct);
    }



    public Product getProductById(int productId) {
        return productRepository.getReferenceById(productId);
    }

    public Product getProductByHash(String productHash) {
        return productRepository.findByProductHash(productHash);
    }


    public Product updateProduct(ProductDTO productDto) {
        //Ultimately redundant, todo: mutate object in db via ID
        Product newProduct = new Product(
                productDto.getProductId(),
                productDto.getProductHash(),
                productDto.getProductName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
        return productRepository.save(newProduct);
    }
//todo clean this mess up
    public boolean deleteProductById(int productId) {
//        Todo make validation more elegant via "try" block in controller
        boolean deleteBool = false;
        try {
            productRepository.deleteById(productId);
            deleteBool = true;
        } catch (Exception e) {
            System.out.println("No product found with id: " + productId);
        }
        return deleteBool;
    }
    public void deleteProductByProductHash(String productHash) {
        productRepository.deleteByProductHash(productHash);
    }



}
