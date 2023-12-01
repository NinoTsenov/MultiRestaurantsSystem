package com.NinoAndCheciRestaurants.restaurantsSystem.service;


import com.NinoAndCheciRestaurants.restaurantsSystem.dto.CategoryRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);
    void deleteCategoryById (Long id);
    CategoryResponse updateCategory (Long id, CategoryRequest request);
    List<CategoryResponse> getAllCategories();

}
