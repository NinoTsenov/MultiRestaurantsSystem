package com.NinoAndCheciRestaurants.restaurantsSystem.converter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Restaurant;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Review;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.ReviewRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Component
@AllArgsConstructor

public class RestaurantConverter {

    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;

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
        Double rating = calculateAverageRating(restaurant);
        response.setId(restaurant.getId());
        response.setRestaurantName(restaurant.getRestaurantName());
        response.setRestaurantDescription(restaurant.getRestaurantDescription());
        response.setRestaurantAddress(restaurant.getRestaurantAddress());
        response.setRestaurantPhoneNumber(restaurant.getRestaurantPhoneNumber());
        response.setRestaurantEmail(restaurant.getRestaurantEmail());
        response.setRating(rating);
        return response;
    }
    public double calculateAverageRating(Restaurant restaurant) {
        List<Review> allReviews = reviewRepository.findAll();

        OptionalDouble average = allReviews.stream()
                .mapToInt(review -> Optional.ofNullable(review.getNumberStars()).orElse(0))
                .average();
        return Math.round(average.orElse(0.0)*100.0)/100.0;
    }

//    public double calculateAverageRating(Restaurant restaurant) {
//        List<Review> allReviews = reviewRepository.findAll();
//        if (allReviews == null || allReviews.isEmpty()) {
//            return 0.0;
//        }
//        int totalStars = 0;
//        int validReviewsCount = 0;
//
//        for (Review review : allReviews) {
//            Integer numberStars = review.getNumberStars();
//            if (numberStars != null) {
//                totalStars += numberStars;
//                validReviewsCount++;
//            }
//        }
//        return validReviewsCount > 0 ? (double) totalStars / validReviewsCount : 0.0;
//    }
}
