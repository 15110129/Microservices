package com.microservices.zuulgateway.repository;

import com.microservices.zuulgateway.entity.Role;
import com.microservices.zuulgateway.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
