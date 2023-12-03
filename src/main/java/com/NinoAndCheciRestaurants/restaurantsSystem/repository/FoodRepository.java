package com.NinoAndCheciRestaurants.restaurantsSystem.repository;

import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Category;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alexander.yordanov on 2023-12-03.
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Long>
{
}
