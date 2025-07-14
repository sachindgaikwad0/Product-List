package com.codebook.dto;

import com.codebook.entity.Category;

public record ProductDTO(Long id,String name, String description, Double price, Category category) {
}
