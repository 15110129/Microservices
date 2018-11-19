package com.microservices.orderservice.repository;

import com.microservices.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findOrderEntityByUsernameAndOrdered(String username, boolean ordered);
    List<OrderEntity> findOrderEntityByOrdered(boolean ordered);
}
