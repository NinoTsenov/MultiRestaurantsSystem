package com.NinoAndCheciRestaurants.restaurantsSystem.service.impl;
import com.NinoAndCheciRestaurants.restaurantsSystem.converter.ReviewConverter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.ReviewRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.ReviewResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Review;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.ReviewRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;

    @Override
    public ReviewResponse createReviewByRestaurantId(Long id, ReviewRequest request) {

        Review review = reviewConverter.createReview(id, request);
        Review savedReview = reviewRepository.save(review);
        return reviewConverter.toReviewResponse(savedReview);
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);

    }

    @Override
    public Review updateReviewById(Long id, ReviewRequest request) {
        Review review = reviewRepository.findById(id).orElseThrow(()-> new RuntimeException("No such review found"));
        if (review.getComment() == null || request.getComment()!=null) {
            review.setComment(review.getComment());
        }
        if (review.getNumberStars() == null || request.getNumberStars()!=null) {
            review.setNumberStars(review.getNumberStars());
        }
        return reviewRepository.save(review);
    }

    @Override
    public List<ReviewResponse> getAllReviewsByRestaurantId(Long restaurantId) {

        List<Review> allReviews = reviewRepository.findAll();
        return allReviews.stream()
                .filter(f-> {Long id = f.getRestaurant().getId();
                return id !=null && id.equals(restaurantId);})
                .map(reviewConverter::toReviewResponse).toList();
    }
}
