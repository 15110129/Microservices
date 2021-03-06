package com.microservices.productservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long id;

    @NotNull
    private String productName;

    @NotNull
    private Long price;

    private String author;

    @Column(name = "description")
    @Lob
    private String desc;

    private String productPicture;

    @NotNull
    private boolean active;

    @NotNull
    @ManyToOne
    private Category category;

    public Product(@NotNull String productName, @NotNull Long price, String author, String desc, String productPicture, @NotNull boolean active, @NotNull Category category) {
        this.productName = productName;
        this.price = price;
        this.author = author;
        this.desc = desc;
        this.productPicture = productPicture;
        this.active = active;
        this.category = category;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}