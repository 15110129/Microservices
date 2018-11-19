package com.microservices.orderservice.service;

import com.microservices.orderservice.model.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDTO> findProductByOrder(Long idOrder);

    OrderDetailDTO insertOrderDetail(OrderDetailDTO orderDetailDTO);

    OrderDetailDTO updateOrderDetail(Long id, OrderDetailDTO dataOrderDetailDTO);

    boolean deleteOrderDetail(Long id);
}
