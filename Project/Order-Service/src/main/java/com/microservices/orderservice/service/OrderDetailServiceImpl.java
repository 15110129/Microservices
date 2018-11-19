package com.microservices.orderservice.service;

import com.microservices.orderservice.entity.OrderDetail;
import com.microservices.orderservice.entity.OrderEntity;
import com.microservices.orderservice.exception.OrderNotFoundException;
import com.microservices.orderservice.mapper.OrderDetailMapper;
import com.microservices.orderservice.model.OrderDetailDTO;
import com.microservices.orderservice.repository.OrderDetailRepository;
import com.microservices.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDetailDTO> findProductByOrder(Long idOrder) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(idOrder);
        if (!orderEntity.isPresent())
            throw new OrderNotFoundException("Order id " + idOrder + " not existed");
        List<OrderDetail> orderDetails = orderDetailRepository.findOrderDetailByOrder(orderEntity.get());
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails)
            orderDetailDTOS.add(OrderDetailMapper.toOrderDetailDTO(orderDetail));

        return orderDetailDTOS;
    }

    @Override
    public OrderDetailDTO insertOrderDetail(OrderDetailDTO orderDetailDTO) {
        Optional<OrderDetail> orderDetail;
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderDetailDTO.getOrderId());
        if (!orderEntity.isPresent())
            throw new OrderNotFoundException("Order id " + orderDetailDTO.getOrderId() + " not existed");
        orderDetail = orderDetailRepository.findOrderDetailByOrderAndIdProduct(orderEntity.get(), orderDetailDTO.getIdProduct());
        if (!orderDetail.isPresent()) {
            orderDetail = Optional.of(OrderDetailMapper.toOrderDetail(orderDetailDTO));
            orderDetail.get().setOrder(orderEntity.get());

            orderDetailDTO = OrderDetailMapper.toOrderDetailDTO(orderDetailRepository.save(orderDetail.get()));
            return orderDetailDTO;
        } else return null;
    }

    @Override
    public OrderDetailDTO updateOrderDetail(Long idOrder, OrderDetailDTO dataOrderDetailDTO) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(idOrder);
        Optional<OrderDetail> orderDetail = orderDetailRepository.findOrderDetailByOrderAndIdProduct(orderEntity.get(), dataOrderDetailDTO.getIdProduct());
        orderDetail.get().setQuantity(dataOrderDetailDTO.getQuantity());
        dataOrderDetailDTO = OrderDetailMapper.toOrderDetailDTO(orderDetailRepository.save(orderDetail.get()));

        return dataOrderDetailDTO;
    }

    @Override
    public boolean deleteOrderDetail(Long id) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
        if(!orderDetail.isPresent())
            throw new OrderNotFoundException("OrderDetail not existed");
        orderDetailRepository.delete(orderDetail.get());

        return (!orderDetailRepository.existsById(orderDetail.get().getId()));
    }
}