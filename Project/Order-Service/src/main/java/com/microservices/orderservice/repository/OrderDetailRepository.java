package com.microservices.orderservice.repository;

import com.microservices.orderservice.entity.OrderDetail;
import com.microservices.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findOrderDetailByOrder(OrderEntity orderEntity);

    Optional<OrderDetail> findOrderDetailByOrderAndIdProduct(OrderEntity orderEntity, Long idProduct);
}
