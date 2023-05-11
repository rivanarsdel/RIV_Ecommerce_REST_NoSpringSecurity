package dev.riv.REST_TurboBasic.repositories;

import dev.riv.REST_TurboBasic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

}
