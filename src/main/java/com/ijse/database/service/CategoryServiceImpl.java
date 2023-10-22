package com.ijse.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.database.entity.Category;
import com.ijse.database.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category exisitingCategory = categoryRepository.findById(id).orElse(null);

        if(exisitingCategory != null) {
            exisitingCategory.setName(category.getName());
            return categoryRepository.save(exisitingCategory);
        } else {
            return null;
        }
    }
}
