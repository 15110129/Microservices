package com.microservices.productservice.service;

import com.microservices.productservice.entity.Category;
import com.microservices.productservice.entity.Product;
import com.microservices.productservice.exception.ResourceNotFoundException;
import com.microservices.productservice.mapper.ProductMapper;
import com.microservices.productservice.model.ProductDTO;
import com.microservices.productservice.repository.CategoryRepository;
import com.microservices.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<ProductDTO> findAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = ProductMapper.toProductDTO(product);
            System.out.println(productDTO.getProductName());
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    @Override
    public List<ProductDTO> findProductByCategory(Long idCategory) {
        Optional<Category> category = categoryRepository.findById(idCategory);
        if (!category.isPresent())
            throw new ResourceNotFoundException("Category id " + idCategory + " not existed");
        List<Product> products = productRepository.findProductByCategory(category.get());
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products)
            productDTOS.add(ProductMapper.toProductDTO(product));

        return productDTOS;
    }

    @Override
    public ProductDTO findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent())
            throw new ResourceNotFoundException("Product id " + id + " not existed");
        ProductDTO productDTO = new ProductDTO();
        productDTO = ProductMapper.toProductDTO(product.get());

        return productDTO;
    }

    @Override
    public ProductDTO insertProduct(ProductDTO productDTO) {
        if (productDTO == null)
            throw new ResourceNotFoundException("Object is null");
        Product product;
        Optional<Category> category = categoryRepository.findById(productDTO.getIdCategory());
        product = ProductMapper.toProduct(productDTO);
        product.setCategory(category.get());
        productDTO = ProductMapper.toProductDTO(productRepository.save(product));

        return productDTO;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO dataProductDTO) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent())
            throw new ResourceNotFoundException("Product id " + id + " not existed");
        Optional<Category> category = categoryRepository.findById(dataProductDTO.getIdCategory());
        if (!category.isPresent())
            throw new ResourceNotFoundException("Category id " + dataProductDTO.getIdCategory() + " not existed");
        dataProductDTO.setId(id);
        product = Optional.of(ProductMapper.toProduct(dataProductDTO));
        product.get().setCategory(category.get());
        productRepository.save(product.get());
        dataProductDTO = ProductMapper.toProductDTO(productRepository.save(product.get()));
        return dataProductDTO;
    }

    @Override
    public boolean deleteProducte(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent())
            throw new ResourceNotFoundException("Product id " + id + " not existed");
        productRepository.delete(product.get());
        return (!productRepository.existsById(id));
    }
}
