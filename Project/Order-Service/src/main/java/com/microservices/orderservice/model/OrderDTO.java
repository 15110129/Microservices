package com.microservices.orderservice.model;

import java.time.LocalDateTime;

public class OrderDTO {

    private Long id;

    private String username;

    private String name;

    private String address;

    private LocalDateTime dateTime;

    private Double total;

    private boolean ordered;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String username, String name, String address, LocalDateTime dateTime, Double total, boolean ordered) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.dateTime = dateTime;
        this.total = total;
        this.ordered = ordered;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }
}
