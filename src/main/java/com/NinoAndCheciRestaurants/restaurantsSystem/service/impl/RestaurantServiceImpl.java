package com.NinoAndCheciRestaurants.restaurantsSystem.service.impl;

import com.NinoAndCheciRestaurants.restaurantsSystem.converter.RestaurantConverter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Restaurant;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.RestaurantRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantConverter restaurantConverter;

    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest request) {
        return null;
    }

    @Override
    public void deleteRestaurantById(Long id) {

    }

    @Override
    public Restaurant updateRestaurant(Long id, RestaurantRequest request) {
        return null;
    }

    @Override
    public List<RestaurantResponse> getAllRestaurants() {
        return null;
    }
}
