package com.auth.jwt.angular.JWTAuthAngular.repositories;

import com.auth.jwt.angular.JWTAuthAngular.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
}
