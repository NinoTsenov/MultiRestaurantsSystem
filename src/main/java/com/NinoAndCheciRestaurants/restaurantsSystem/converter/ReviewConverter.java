package com.NinoAndCheciRestaurants.restaurantsSystem.converter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.ReviewRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.ReviewResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Restaurant;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Review;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@AllArgsConstructor

public class ReviewConverter {

    private final RestaurantRepository restaurantRepository;


    public Review createReview (Long id, ReviewRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No such restaurant found !"));

        return Review.builder()
                .restaurant(restaurant)
                .numberStars(request.getNumberStars())
                .comment(request.getComment())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public ReviewResponse toReviewResponse (Review review){

        return ReviewResponse.builder()
                .id(review.getId())
                .numberStars(review.getNumberStars())
                .comment(review.getComment())
                .restaurant(review.getRestaurant().getRestaurantName())
                .createdAt(review.getCreatedAt())
                .build();
    }
}
