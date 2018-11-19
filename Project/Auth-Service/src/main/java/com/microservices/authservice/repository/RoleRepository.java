package com.microservices.authservice.repository;

import com.microservices.authservice.entity.Role;
import com.microservices.authservice.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
