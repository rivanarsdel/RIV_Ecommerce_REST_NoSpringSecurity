package dev.riv.REST_TurboBasic.repositories;

import dev.riv.REST_TurboBasic.modelHelpers.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, String> {
}
