package dev.riv.REST_TurboBasic.services;

import dev.riv.REST_TurboBasic.modelHelpers.ProductImage;
import dev.riv.REST_TurboBasic.utilities.HashGenerator;
import dev.riv.REST_TurboBasic.modelDTOs.ProductDTO;
import dev.riv.REST_TurboBasic.models.Product;
import dev.riv.REST_TurboBasic.repositories.ProductRepository;
import dev.riv.REST_TurboBasic.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

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
    public Product upsertProduct(ProductDTO productDto) throws NoSuchAlgorithmException {

        Product localProduct = productRepository.findByProductHash(productDto.getProductHash());
        if(localProduct.getProductId() != 0) { productDto.setProductId(localProduct.getProductId()); }
        if(productDto.getProductHash().equals("")) { productDto.setProductHash(hashGenerator.createMD5Hash()); }

        Product newProduct = new Product(
                productDto.getProductId(),
                productDto.getProductHash(),
                productDto.getProductName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
        ProductImage newProductImage = new ProductImage(
                productDto.getProductImageId(),
                productDto.getLinkedProductHash(),
                productDto.getImageName(),
                productDto.getEncodedImage()
        );

        productImageRepository.save(newProductImage);
        return productRepository.save(newProduct);
    }
    public ProductImage upsertProductImage(ProductDTO productDTO) {
        ProductImage newProductImage = new ProductImage(
                productDTO.getProductImageId(),
                productDTO.getLinkedProductHash(),
                productDTO.getImageName(),
                productDTO.getEncodedImage()
        );
        return productImageRepository.save(newProductImage);
    }
    public Product getProductById(int productId) {
        return productRepository.getReferenceById(productId);
    }
    public ProductImage getProductImageById(int productImageId) {
        return productImageRepository.getReferenceById(productImageId);
    }
    public Product getProductByHash(String productHash) {
        return productRepository.findByProductHash(productHash);
    }
    public List<ProductImage> getProductImagesByProductHash(String productHash) {
        return productImageRepository.findAllByLinkedProductHash(productHash);
    }
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }

    public void deleteProductByProductHash(String productHash) {
        productRepository.deleteByProductHash(productHash);
    }
}
