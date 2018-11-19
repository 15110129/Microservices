package com.microservices.reviewservice.model;

import java.time.LocalDateTime;

public class ReviewDTO {

    private Long id;

    private Long productId;

    private String username;

    private String content;

    private LocalDateTime dateTime;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, Long productId, String username, String content, LocalDateTime dateTime) {
        this.id = id;
        this.productId = productId;
        this.username = username;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
