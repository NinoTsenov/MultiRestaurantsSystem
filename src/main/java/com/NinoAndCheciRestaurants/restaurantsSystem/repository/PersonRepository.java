package com.NinoAndCheciRestaurants.restaurantsSystem.repository;

import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
