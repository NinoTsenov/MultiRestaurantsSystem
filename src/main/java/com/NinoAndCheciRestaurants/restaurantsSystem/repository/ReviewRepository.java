package com.NinoAndCheciRestaurants.restaurantsSystem.repository;

import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
