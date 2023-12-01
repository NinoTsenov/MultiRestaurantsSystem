package com.NinoAndCheciRestaurants.restaurantsSystem.converter;

import com.NinoAndCheciRestaurants.restaurantsSystem.dto.CategoryRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.CategoryResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryConverter {

    public Category createCategory(CategoryRequest request){

        return Category.builder()
                .categoryName(request.getCategoryName())
                .categoryDescription(request.getCategoryDescription())
                .build();
    }

    public CategoryResponse toCategoryResponse(Category category){
          CategoryResponse response = new CategoryResponse();
            response.setId(category.getId());
            response.setCategoryName(category.getCategoryName());
            response.setCategoryDescription(category.getCategoryDescription());
            return response;
    }

}
