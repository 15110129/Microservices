package com.microservices.productservice.mapper;

import com.microservices.productservice.entity.Category;
import com.microservices.productservice.model.CategoryDTO;

public final class CategoryMapper {
    static public CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setActive(category.isActive());

        return categoryDTO;
    }

    static public Category toCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setActive(categoryDTO.isActive());

        return category;
    }
}
