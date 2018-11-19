package com.microservices.orderservice.service;

import com.microservices.orderservice.entity.OrderDetail;
import com.microservices.orderservice.entity.OrderEntity;
import com.microservices.orderservice.exception.OrderNotFoundException;
import com.microservices.orderservice.mapper.OrderMapper;
import com.microservices.orderservice.model.OrderDTO;
import com.microservices.orderservice.repository.OrderDetailRepository;
import com.microservices.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDTO> findAllOrder() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities)
            orderDTOS.add(OrderMapper.toOrderDTO(orderEntity));
        return orderDTOS;
    }

    @Override
    public OrderDTO findOrderByUsername(String username) {
        Optional<OrderEntity> orderEntity = orderRepository.findOrderEntityByUsernameAndOrdered(username, false);
        if (!orderEntity.isPresent())
            throw new OrderNotFoundException("Order username " + username + " not existed");
        OrderDTO orderDTO = OrderMapper.toOrderDTO(orderEntity.get());
        return orderDTO;
    }

    @Override
    public List<OrderDTO> findOrderByActive(boolean active) {
        List<OrderEntity> orderEntities = orderRepository.findOrderEntityByOrdered(active);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntities)
            orderDTOS.add(OrderMapper.toOrderDTO(orderEntity));
        return orderDTOS;
    }

    @Override
    public OrderDTO insertOrder(OrderDTO orderDTO) {
        if (orderDTO == null)
            throw new OrderNotFoundException("Object is null");
        OrderEntity orderEntity;
        orderEntity = OrderMapper.toOrderEntity(orderDTO);
        orderEntity.setOrdered(false);
        orderEntity.setDateTime(LocalDateTime.now());
        orderDTO = OrderMapper.toOrderDTO(orderRepository.save(orderEntity));
        return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO dataOrderDTO) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if (!orderEntity.isPresent())
            throw new OrderNotFoundException("Order id " + id + " not existed");
        dataOrderDTO.setId(id);
        orderEntity = Optional.of(OrderMapper.toOrderEntity(dataOrderDTO));
        orderEntity.get().setDateTime(LocalDateTime.now());
        List<OrderDetail> orderDetails = orderDetailRepository.findOrderDetailByOrder(orderEntity.get());
        Double a = 0d;
        for (OrderDetail orderDetail : orderDetails)
            a = a + orderDetail.getUnitPrice() * orderDetail.getQuantity();
        orderEntity.get().setTotal(a);
        orderRepository.save(orderEntity.get());
        return dataOrderDTO;
    }

    @Override
    public boolean deleteOrder(Long id) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        if (!orderEntity.isPresent())
            throw new OrderNotFoundException("Order id " + id + " not existed");
        orderRepository.delete(orderEntity.get());
        return (!orderRepository.existsById(id));
    }
}
