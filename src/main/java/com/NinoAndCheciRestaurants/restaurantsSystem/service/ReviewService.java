package com.NinoAndCheciRestaurants.restaurantsSystem.service;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.ReviewRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.ReviewResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Review;


import java.util.List;

public interface ReviewService {

    ReviewResponse createReviewByRestaurantId(Long id, ReviewRequest request);
    void deleteReviewById (Long id);
    Review updateReviewById (Long id, ReviewRequest request);
    List<ReviewResponse> getAllReviewsByRestaurantId(Long restaurantId);

  // TODO
  // make rating
}
