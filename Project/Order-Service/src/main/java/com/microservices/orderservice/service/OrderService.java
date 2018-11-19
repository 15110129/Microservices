package com.microservices.orderservice.service;

import com.microservices.orderservice.model.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderDTO> findAllOrder();

    OrderDTO findOrderByUsername(String username);

    List<OrderDTO> findOrderByActive(boolean active);

    OrderDTO insertOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(Long id, OrderDTO dataOrderDTO);

    boolean deleteOrder(Long id);
}
