package com.NinoAndCheciRestaurants.restaurantsSystem.service;

import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Restaurant;


import java.util.List;

public interface RestaurantService {
    RestaurantResponse createRestaurant(RestaurantRequest request);
    void deleteRestaurantById (Long id);
    Restaurant updateRestaurant (Long id, RestaurantRequest request);
    List<RestaurantResponse> getAllRestaurants();
}
