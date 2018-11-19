package com.microservices.orderservice.model;

import com.microservices.orderservice.entity.OrderEntity;

public class OrderDetailDTO {
    private Long id;

    private Long orderId;

    private Long idProduct;

    private int quantity;

    private Double unitPrice;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(Long id, Long orderId, Long idProduct, int quantity, Double unitPrice) {
        this.id = id;
        this.orderId = orderId;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
