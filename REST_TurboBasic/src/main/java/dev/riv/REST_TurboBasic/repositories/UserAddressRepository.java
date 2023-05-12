package dev.riv.REST_TurboBasic.repositories;

import dev.riv.REST_TurboBasic.modelHelpers.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, String> {

    public UserAddress findByAddressHash (String addressHash);
    public List<UserAddress> findAllByLinkedUserHash (String userHash);
    public void deleteByAddressHash (String addressHash);
}
