package com.codebook.service;

import com.codebook.dto.CategoryDTO;
import com.codebook.entity.Category;
import com.codebook.mapper.DTOMapper;
import com.codebook.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = DTOMapper.toCategory(categoryDTO);
        Category categorySaved =categoryRepository.save(category);

        return DTOMapper.toCategoryDTO(categorySaved);
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(DTOMapper::toCategoryDTO).toList();
    }
}
