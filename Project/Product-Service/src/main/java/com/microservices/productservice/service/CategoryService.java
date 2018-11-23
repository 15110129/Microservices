package com.microservices.productservice.service;

import com.microservices.productservice.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAllCategory();

    CategoryDTO findById(Long id);

    CategoryDTO insertCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Long id, CategoryDTO dataCategoryDTO);

    boolean deleteCategory(Long id);
}