package dev.riv.REST_TurboBasic.controllers;


import dev.riv.REST_TurboBasic.modelDTOs.ProductDTO;
import dev.riv.REST_TurboBasic.models.Product;
import dev.riv.REST_TurboBasic.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:5000", "http://localhost:8080" } )
public class ProductController {
    private ProductService productService;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public Optional<Product> createProduct(ProductDTO productDTO) throws NoSuchAlgorithmException {
        Product productObj = productService.createProduct(productDTO);
        return Optional.of(productObj);
    }

    @GetMapping("/get")
    //todo path variable inclusion
    public Optional<Product> getProductById(int productId) {
        return Optional.of(productService.getProductById(productId));
    }

    @PutMapping("/update")
    public Optional<Product> updateProduct(ProductDTO productDTO) {
        return Optional.of(productService.updateProduct(productDTO));
    }

    @DeleteMapping("/delete")
    public boolean deleteProductById(int productId){
        return productService.deleteProductById(productId);
    }



}
