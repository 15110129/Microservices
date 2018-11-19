package com.microservices.productservice.controller;

import com.microservices.productservice.entity.Category;
import com.microservices.productservice.model.CategoryDTO;
import com.microservices.productservice.service.CategoryServiceImpl;
import com.microservices.productservice.util.ApiResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping
    public Map<String, ?> findAllCategory() {
        return ApiResponseBuilder.buildContainsData("List Catagory", categoryService.findAllCategory());
    }

    @GetMapping("/{id}")
    public Map<String, ?> findById(@PathVariable Long id) {
        return ApiResponseBuilder.buildContainsData("Catagory id " + id, categoryService.findById(id));
    }

    @PostMapping
    public Map<String, ?> insertCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategory = categoryService.insertCategory(categoryDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Inserted Category id " + savedCategory.getCategoryId()), savedCategory);
    }

    @PutMapping("/{id}")
    public Map<String, ?> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategory = categoryService.updateCategory(id, categoryDTO);
        return ApiResponseBuilder.buildContainsData(String.format("Update Category id " + id), categoryDTO);
    }

    @DeleteMapping("/{id}")
    public Map<String, ?> deleteCategory(@PathVariable Long id) {
        boolean success = categoryService.deleteCategory(id);
        if (success)
            return ApiResponseBuilder.buildSuccess(String.format("Delete Category id " + id + " success"));
        else return ApiResponseBuilder.buildSuccess(String.format("Delete Category id " + id + " fail"));
    }
}
