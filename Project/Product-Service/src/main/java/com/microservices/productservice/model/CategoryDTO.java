package com.microservices.productservice.model;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private Long categoryId;

    private String categoryName;

    private boolean active;

    public CategoryDTO(Long categoryId, String categoryName, boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.active = active;
    }

    public CategoryDTO() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
