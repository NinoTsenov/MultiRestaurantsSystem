package com.NinoAndCheciRestaurants.restaurantsSystem.converter;

import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Restaurant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor

public class RestaurantConverter {

    public Restaurant createRestaurant(RestaurantRequest request) {
        return Restaurant.builder()
                .restaurantName(request.getRestaurantName())
                .restaurantDescription(request.getRestaurantDescription())
                .restaurantAddress(request.getRestaurantAddress())
                .restaurantEmail(request.getRestaurantEmail())
                .restaurantPhoneNumber(request.getRestaurantPhoneNumber())
                .build();
    }

    public RestaurantResponse toRestaurantResponse(Restaurant restaurant){

        RestaurantResponse response = new RestaurantResponse();

     // TODO
     //   List<ReviewResponse> allReviews = new ArrayList<>();

        response.setId(response.getId());
        response.setRestaurantName(restaurant.getRestaurantName());
        response.setRestaurantDescription(restaurant.getRestaurantDescription());
        response.setRestaurantAddress(restaurant.getRestaurantAddress());
        response.setRestaurantPhoneNumber(restaurant.getRestaurantPhoneNumber());
        response.setRestaurantEmail(restaurant.getRestaurantEmail());

        //TODO
        //response.setReviews();

        return response;
    }
}
