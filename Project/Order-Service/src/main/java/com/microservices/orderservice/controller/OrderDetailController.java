package com.microservices.orderservice.controller;

import com.microservices.orderservice.model.OrderDetailDTO;
import com.microservices.orderservice.service.OrderDetailServiceImpl;
import com.microservices.orderservice.util.ApiResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
    @Autowired
    OrderDetailServiceImpl orderDetailService;

    @GetMapping("/{idOrder}")
    public Map<String, ?> findProductByOrder(@PathVariable Long idOrder){
        return ApiResponseBuilder.buildContainsData("List OrderDetail of Order id " + idOrder, orderDetailService.findProductByOrder(idOrder));
    }

    @PostMapping
    public Map<String, ?> insertOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO){
        OrderDetailDTO savedOrderDetailDTO = orderDetailService.insertOrderDetail(orderDetailDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Inserted OrderDetail of Order id " + savedOrderDetailDTO.getId()), savedOrderDetailDTO);
    }

    @PutMapping("/{idOrder}")
    public Map<String, ?> updateOrderDetail(@PathVariable Long idOrder, @RequestBody OrderDetailDTO orderDetailDTO){
        OrderDetailDTO savedOrderDetailDTO =orderDetailService.updateOrderDetail(idOrder, orderDetailDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Update OrderDetail of Order id " + idOrder), savedOrderDetailDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, ?> deleteOrderDetail(@PathVariable Long id){
        boolean success = orderDetailService.deleteOrderDetail(id);
        if (success)
            return ApiResponseBuilder.buildSuccess(String.format("Delete OrderDetail id " + id + " success"));
        else return ApiResponseBuilder.buildSuccess(String.format("Delete OrderDetail id " + id + " fail"));
    }
}
