package com.codebook.mapper;

import com.codebook.dto.CategoryDTO;
import com.codebook.dto.ProductDTO;
import com.codebook.entity.Category;
import com.codebook.entity.Product;
import com.codebook.repository.CategoryRepository;
import org.springframework.stereotype.Component;

public class DTOMapper {
    public static Category toCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.name());
        return category;
    }

    public static CategoryDTO toCategoryDTO(Category category){
        if(category ==null)
            return null;
        return new CategoryDTO(category.getId(),category.getName(),category.getProducts().stream().map(DTOMapper::toProductDTO).toList());
    }

    public static Product toProduct(ProductDTO productDTO,Category category){
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());
        product.setCategory(category);
        return product;
    }

    public static ProductDTO toProductDTO(Product product){
       return new ProductDTO(product.getId(),product.getName(), product.getDescription(), product.getPrice(), product.getCategory());
    }
}
