package com.NinoAndCheciRestaurants.restaurantsSystem.service.impl;
import com.NinoAndCheciRestaurants.restaurantsSystem.converter.FoodConverter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Food;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.FoodRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService
{
    private final FoodConverter foodConverter;
    private final FoodRepository foodRepository;

    @Override
    public FoodResponse createFood(FoodRequest request)
    {
        Food food = foodConverter.createFood(request);
        Food savedFood = foodRepository.save(food);
        return foodConverter.toFoodResponse(savedFood);
    }

    @Override
    public void deleteFoodById(Long id)
    {
        foodRepository.deleteById(id);
    }

    @Override
    public FoodResponse updateFood(Long id, FoodRequest request)
    {
        Food food = foodRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Food not found !"));
        food.setFoodName(request.getFoodName());
        food.setFoodDescription(request.getFoodDescription());
        foodRepository.save(food);

        return foodConverter.toFoodResponse(food);
    }

    @Override
    public List<FoodResponse> getAllFoods()
    {
        List<Food>allFoods = foodRepository.findAll();
        List<FoodResponse> foundAllFoods = new ArrayList<>();
        for(Food c : allFoods){
            FoodResponse response = foodConverter.toFoodResponse(c);
            foundAllFoods.add(response);
        }
        return foundAllFoods;
    }
}
