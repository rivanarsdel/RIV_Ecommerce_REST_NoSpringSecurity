package dev.riv.REST_TurboBasic.repositories;

import dev.riv.REST_TurboBasic.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepository extends JpaRepository<Order, String> {
}
