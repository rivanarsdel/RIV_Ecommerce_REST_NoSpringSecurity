package dev.riv.REST_TurboBasic.repositories;

import dev.riv.REST_TurboBasic.modelHelpers.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    public List<ProductImage> findAllByLinkedProductHash(String linkedProductHash);
}
