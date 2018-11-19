package com.microservices.orderservice.mapper;

import com.microservices.orderservice.entity.OrderEntity;
import com.microservices.orderservice.model.OrderDTO;

public class OrderMapper {
    static public OrderDTO toOrderDTO(OrderEntity orderEntity){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setUsername(orderEntity.getUsername());
        orderDTO.setName(orderEntity.getName());
        orderDTO.setAddress(orderEntity.getAddress());
        orderDTO.setDateTime(orderEntity.getDateTime());
        orderDTO.setName(orderDTO.getName());
        orderDTO.setOrdered(orderEntity.isOrdered());
        orderDTO.setTotal(orderEntity.getTotal());

        return orderDTO;
    }

    static public OrderEntity toOrderEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDTO.getId());
        orderEntity.setUsername(orderDTO.getUsername());
        orderEntity.setAddress(orderDTO.getAddress());
        orderEntity.setDateTime(orderDTO.getDateTime());
        orderEntity.setName(orderDTO.getName());
        orderEntity.setOrdered(orderDTO.isOrdered());
        orderEntity.setTotal(orderDTO.getTotal());

        return orderEntity;
    }
}
