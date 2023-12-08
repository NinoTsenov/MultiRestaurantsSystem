package com.NinoAndCheciRestaurants.restaurantsSystem.service.impl;
import com.NinoAndCheciRestaurants.restaurantsSystem.converter.RestaurantConverter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Restaurant;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.RestaurantRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantConverter restaurantConverter;

    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest request) {
        Restaurant restaurant = restaurantConverter.createRestaurant(request);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return restaurantConverter.toRestaurantResponse(savedRestaurant) ;
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurant updateRestaurant(Long id, RestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Restaurant not found"));

        if (restaurant.getRestaurantName() == null || request.getRestaurantName()!=null) {
            restaurant.setRestaurantName(restaurant.getRestaurantName());
        }
        if (restaurant.getRestaurantDescription() == null || request.getRestaurantDescription()!=null) {
            restaurant.setRestaurantDescription(restaurant.getRestaurantDescription());
        }
        if (restaurant.getRestaurantAddress() == null || request.getRestaurantAddress()!=null) {
            restaurant.setRestaurantAddress(restaurant.getRestaurantAddress());
        }
        if (restaurant.getRestaurantEmail() == null || request.getRestaurantEmail()!=null) {
            restaurant.setRestaurantEmail(restaurant.getRestaurantEmail());
        }
        if (restaurant.getRestaurantPhoneNumber() == null || request.getRestaurantPhoneNumber()!=null) {
            restaurant.setRestaurantPhoneNumber(request.getRestaurantPhoneNumber());
        }

        // restaurant.setBanner..... TODO

        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<RestaurantResponse> getAllRestaurants() {
        List<Restaurant> allRestaurants = restaurantRepository.findAll();
        List<RestaurantResponse> allRestaurantsResponse = new ArrayList<>();
        for (Restaurant r : allRestaurants){
            allRestaurantsResponse.add(restaurantConverter.toRestaurantResponse(r));
        }
        return allRestaurantsResponse;
    }

    @Override
    public RestaurantResponse findRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Restaurant not found"));
        return restaurantConverter.toRestaurantResponse(restaurant);
    }
}
