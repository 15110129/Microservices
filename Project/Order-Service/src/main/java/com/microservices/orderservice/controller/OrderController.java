package com.microservices.orderservice.controller;

import com.microservices.orderservice.model.OrderDTO;
import com.microservices.orderservice.service.OrderServiceImpl;
import com.microservices.orderservice.util.ApiResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;

    @GetMapping
    public Map<String, ?> findAllOrder() {
        return ApiResponseBuilder.buildContainsData("List Order", orderService.findAllOrder());
    }

    @GetMapping("/username/{username}")
    public Map<String, ?> findOrderByUsername(@PathVariable String username) {
        return ApiResponseBuilder.buildContainsData("Order of username " + username, orderService.findOrderByUsername(username));
    }

    @GetMapping("/active/{active}")
    public Map<String, ?> findOrderByActive(@PathVariable boolean active) {
        return ApiResponseBuilder.buildContainsData("List Order " + active, orderService.findOrderByActive(active));
    }

    @PostMapping
    public Map<String, ?> insertOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO savedOrderDTO = orderService.insertOrder(orderDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Inserted Order id " + savedOrderDTO.getId()), savedOrderDTO);
    }

    @PutMapping("/{id}")
    public Map<String, ?> updateOrder(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO savedOrderDTO = orderService.updateOrder(id, orderDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Update Order id " + id), savedOrderDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, ?> deleteOrder(@PathVariable Long id) {
        boolean success = orderService.deleteOrder(id);
        if (success)
            return ApiResponseBuilder.buildSuccess(String.format("Delete Order id " + id + " success"));
        else return ApiResponseBuilder.buildSuccess(String.format("Delete Order id " + id + " fail"));
    }
}
