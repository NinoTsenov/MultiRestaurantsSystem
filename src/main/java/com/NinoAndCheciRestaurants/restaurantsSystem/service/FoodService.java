package com.NinoAndCheciRestaurants.restaurantsSystem.service;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodResponse;

import java.util.List;

public interface FoodService
{
    FoodResponse createFood(FoodRequest request);
    void deleteFoodById (Long id);
    FoodResponse updateFood (Long id, FoodRequest request);
    List<FoodResponse> getAllFoods();
}
