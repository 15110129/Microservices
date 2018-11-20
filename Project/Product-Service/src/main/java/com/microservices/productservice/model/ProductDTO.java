package com.microservices.productservice.model;

import java.io.Serializable;


public class ProductDTO implements Serializable {
    private Long id;

    private Long idCategory;

    private String productName;

    private Long price;

    private String author;

    private String desc;

    private String productPicture;

    private boolean active;

    public ProductDTO() {
    }

    public ProductDTO(Long id, Long idCategory, String productName, Long price, String author, String desc, String productPicture, boolean active) {
        this.id = id;
        this.idCategory = idCategory;
        this.productName = productName;
        this.price = price;
        this.author = author;
        this.desc = desc;
        this.productPicture = productPicture;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
