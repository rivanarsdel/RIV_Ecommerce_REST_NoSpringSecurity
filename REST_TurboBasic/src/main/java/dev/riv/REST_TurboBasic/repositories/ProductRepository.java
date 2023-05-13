package dev.riv.REST_TurboBasic.repositories;

import dev.riv.REST_TurboBasic.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Product findByProductHash(String productHash);
    public void deleteByProductHash(String productHash);


}
