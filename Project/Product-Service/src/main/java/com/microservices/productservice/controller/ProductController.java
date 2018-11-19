package com.microservices.productservice.controller;

import com.microservices.productservice.entity.Product;
import com.microservices.productservice.model.ProductDTO;
import com.microservices.productservice.service.ProductServiceImpl;
import com.microservices.productservice.util.ApiResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping
    public Map<String, ?> findAllProduct() {
        return ApiResponseBuilder.buildContainsData("List Product", productService.findAllProduct());
    }

    @GetMapping("/category/{idCategory}")
    public Map<String, ?> findProductByCategory(@PathVariable Long idCategory) {
        return ApiResponseBuilder.buildContainsData("List Product of Category " + idCategory, productService.findProductByCategory(idCategory));
    }

    @GetMapping("/{id}")
    public Map<String, ?> findProductById(@PathVariable Long id) {
        return ApiResponseBuilder.buildContainsData("Product id " + id, productService.findProductById(id));
    }

    @PostMapping
    public Map<String, ?> insertProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProductDTO = productService.insertProduct(productDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Inserted Product id " + savedProductDTO.getId()), savedProductDTO);
    }

    @PutMapping("/{id}")
    public Map<String, ?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO savedProductDTO = productService.updateProduct(id, productDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Update Product id " + id), savedProductDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, ?> deleteProduct(@PathVariable Long id) {
        boolean success = productService.deleteProducte(id);
        if (success)
            return ApiResponseBuilder.buildSuccess(String.format("Delete Product id " + id + " success"));
        else return ApiResponseBuilder.buildSuccess(String.format("Delete Product id " + id + " fail"));
    }
}

