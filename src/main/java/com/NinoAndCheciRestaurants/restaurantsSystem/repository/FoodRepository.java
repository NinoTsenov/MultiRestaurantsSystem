package com.NinoAndCheciRestaurants.restaurantsSystem.repository;

import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{}
