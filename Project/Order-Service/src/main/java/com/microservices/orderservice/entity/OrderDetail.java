package com.microservices.orderservice.entity;

import javax.persistence.*;

@Entity(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private OrderEntity order;

    @Column(name = "productId")
    private Long idProduct;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(Long id, OrderEntity order, Long idProduct, int quantity, Double unitPrice) {
        this.id = id;
        this.order = order;
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

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
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
