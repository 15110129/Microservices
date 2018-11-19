package com.microservices.authservice.repository;

import com.microservices.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);

    Boolean existsByUsername(String username);
}
