package com.NinoAndCheciRestaurants.restaurantsSystem.converter;

import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Food;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.CategoryRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.FoodRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
@AllArgsConstructor
public class FoodConverter
{
    private FoodRepository foodRepository;
    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;

    public Food createFood(FoodRequest request)
    {
        List<Food> foods = new ArrayList<>();
        for (Long foodId : request.getFoodId())
        {
            foods.add(foodRepository.findById(foodId).orElseThrow());
        }
        return Food.builder()
                .foodName(request.getFoodName())
                .foodDescription(request.getFoodDescription())
                .category(categoryRepository.findById(request.getCategoryId()).orElseThrow())
                .foodList(foods)
                .foodBanner(Base64.getDecoder().decode(request.getFoodBanner()))
                .build();
    }

    public FoodResponse toFoodResponse(Food food)
    {
        List<FoodResponse> foods = new ArrayList<>();
        for (Food food1 : food.getFoodList())
        {
            foods.add(this.toFoodResponse(food1));
        }
        FoodResponse response = new FoodResponse();
            response.setId(food.getId());
            response.setFoodName(food.getFoodName());
            response.setFoodDescription(food.getFoodDescription());
            response.setCategory(categoryConverter.toCategoryResponse(food.getCategory()));
            response.setFood(foods);
            response.setFoodBanner(Base64.getEncoder().encodeToString(food.getFoodBanner()));
            return response;
    }

}
