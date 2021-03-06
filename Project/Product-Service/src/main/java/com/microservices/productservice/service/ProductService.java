package com.microservices.productservice.service;

import com.microservices.productservice.model.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProduct();

    List<ProductDTO> findProductByCategory(Long idCategory);

    List<ProductDTO> findProductByName(String name);

    ProductDTO findProductById(Long id);

    ProductDTO insertProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    boolean deleteProducte(Long id);
}
