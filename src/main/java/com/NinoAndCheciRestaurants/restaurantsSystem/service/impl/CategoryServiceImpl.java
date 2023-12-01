package com.NinoAndCheciRestaurants.restaurantsSystem.service.impl;

import com.NinoAndCheciRestaurants.restaurantsSystem.converter.CategoryConverter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.CategoryRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.CategoryResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Category;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.CategoryRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    private final CategoryConverter categoryConverter;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = categoryConverter.createCategory(request);
        Category savedCategory = categoryRepository.save(category);

        return categoryConverter.toCategoryResponse(savedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Category not found !"));
        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());

        return categoryConverter.toCategoryResponse(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category>allCategories = categoryRepository.findAll();
        List<CategoryResponse> foundAllCategories = new ArrayList<>();
        for(Category c : allCategories){
         CategoryResponse response = categoryConverter.toCategoryResponse(c);
         foundAllCategories.add(response);
        }
        return foundAllCategories;
    }
}
