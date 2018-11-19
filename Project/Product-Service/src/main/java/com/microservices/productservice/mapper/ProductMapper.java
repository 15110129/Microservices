package com.microservices.productservice.mapper;

import com.microservices.productservice.entity.Category;
import com.microservices.productservice.entity.Product;
import com.microservices.productservice.model.ProductDTO;

public class ProductMapper {
    static public ProductDTO toProductDTO(Product product) {
        Category category;
        category = product.getCategory();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setActive(product.isActive());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPicture(product.getProductPicture());
        productDTO.setIdCategory(category.getCategoryId());

        return productDTO;
    }

    static public Product toProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setActive(productDTO.isActive());
        product.setPrice(productDTO.getPrice());
        product.setProductName(productDTO.getProductName());
        product.setProductPicture(productDTO.getProductPicture());

        return product;
    }
}
