package dev.riv.REST_TurboBasic.repositories;

import dev.riv.REST_TurboBasic.modelHelpers.OrderProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductQuantityRepository extends JpaRepository<OrderProductQuantity, String> {
}
