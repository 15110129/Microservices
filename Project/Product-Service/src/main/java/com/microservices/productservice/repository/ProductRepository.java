package com.microservices.productservice.repository;

import com.microservices.productservice.entity.Category;
import com.microservices.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCategory(Category category);
    List<Product> findProductsByProductNameLike(String name);
}
