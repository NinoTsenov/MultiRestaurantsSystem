package com.NinoAndCheciRestaurants.restaurantsSystem.converter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Food;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.CategoryRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.FoodRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.Base64;


@Component
@AllArgsConstructor
public class FoodConverter
{
    private FoodRepository foodRepository;
    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;

    public Food createFood(FoodRequest request)
    {
        return Food.builder()
                .foodName(request.getFoodName())
                .foodDescription(request.getFoodDescription())
                .category(categoryRepository.findById(request.getCategoryId()).orElseThrow())
                .price(request.getPrice())
                .foodBanner(Base64.getDecoder().decode(request.getFoodBanner()))
                .build();
    }

    public FoodResponse toFoodResponse(Food food)
    {

        FoodResponse response = new FoodResponse();
            response.setId(food.getId());
            response.setFoodName(food.getFoodName());
            response.setFoodDescription(food.getFoodDescription());
            response.setCategory(categoryConverter.toCategoryResponse(food.getCategory()));
            response.setPrice(food.getPrice());

            response.setFoodBanner(Base64.getEncoder().encodeToString(food.getFoodBanner()));
            return response;
    }

}
