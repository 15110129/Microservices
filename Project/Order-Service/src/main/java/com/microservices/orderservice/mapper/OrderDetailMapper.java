package com.microservices.orderservice.mapper;

import com.microservices.orderservice.entity.OrderDetail;
import com.microservices.orderservice.model.OrderDetailDTO;

public class OrderDetailMapper {
    static public OrderDetailDTO toOrderDetailDTO (OrderDetail orderDetail) {
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setId(orderDetail.getId());
        orderDetailDTO.setIdProduct(orderDetail.getIdProduct());
        orderDetailDTO.setOrderId(orderDetail.getOrder().getId());
        orderDetailDTO.setQuantity(orderDetail.getQuantity());
        orderDetailDTO.setUnitPrice(orderDetail.getUnitPrice());

        return orderDetailDTO;
    }

    static public OrderDetail toOrderDetail (OrderDetailDTO orderDetailDTO){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(orderDetailDTO.getId());
        orderDetail.setIdProduct(orderDetailDTO.getIdProduct());
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setUnitPrice(orderDetailDTO.getUnitPrice());

        return orderDetail;
    }
}
