package dev.riv.REST_TurboBasic.repositories;

import dev.riv.REST_TurboBasic.modelHelpers.ProductImageList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageList, Integer> {
}
