package com.NinoAndCheciRestaurants.restaurantsSystem.controller;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.ReviewRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.ReviewResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Review;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor

public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/createReviewByRestaurantId/{id}")
    public ResponseEntity<ReviewResponse> createReview(@PathVariable Long id, @Valid @RequestBody ReviewRequest request){
        ReviewResponse createdReview = reviewService.createReviewByRestaurantId(id,request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    @GetMapping("/getAllReviewsByRestaurantId/{id}")
    public ResponseEntity<List<ReviewResponse>> getAllReviews(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getAllReviewsByRestaurantId(id));
    }

    @PutMapping("/updateReview/{id}")
    public ResponseEntity<Review> updateReview
            (@PathVariable Long id, @Valid @RequestBody ReviewRequest request){
        Review updatedReview = reviewService.updateReviewById(id, request);
        if(updatedReview!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedReview);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deleteReview/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id){
        reviewService.deleteReviewById(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Review was successfully deleted");
    }
}
