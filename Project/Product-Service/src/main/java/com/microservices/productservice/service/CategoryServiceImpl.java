package com.microservices.productservice.service;

import com.microservices.productservice.entity.Category;
import com.microservices.productservice.exception.ResourceNotFoundException;
import com.microservices.productservice.mapper.CategoryMapper;
import com.microservices.productservice.model.CategoryDTO;
import com.microservices.productservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> findAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories)
            categoryDTOS.add(CategoryMapper.toCategoryDTO(category));
        return categoryDTOS;
    }

    @Override
    public CategoryDTO findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (!category.isPresent())
            throw new ResourceNotFoundException("Category id " + id + " not existed");
        CategoryDTO categoryDTO = CategoryMapper.toCategoryDTO(category.get());
        return categoryDTO;
    }

    @Override
    public CategoryDTO insertCategory(CategoryDTO categoryDTO) {
        if (categoryDTO == null)
            throw new ResourceNotFoundException("Object is null");
        Category category = new Category();
        System.out.println(categoryDTO.getCategoryName());
        System.out.println(categoryDTO.isActive());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setActive(categoryDTO.isActive());
        categoryDTO = CategoryMapper.toCategoryDTO(categoryRepository.save(category));
        return categoryDTO;
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO dataCategoryDTO) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent())
            throw new ResourceNotFoundException("Category id " + id + " not existed");
        dataCategoryDTO.setCategoryId(id);
        category = Optional.of(CategoryMapper.toCategory(dataCategoryDTO));
        categoryRepository.save(category.get());
        return dataCategoryDTO;
    }

    @Override
    public boolean deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent())
            throw new ResourceNotFoundException("Category id " + id + " not existed");
        categoryRepository.delete(category.get());
        return (!categoryRepository.existsById(id));
    }
}
