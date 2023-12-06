package com.NinoAndCheciRestaurants.restaurantsSystem.controller;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.RestaurantResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Restaurant;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor

public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/createRestaurant")
    public ResponseEntity<RestaurantResponse> createRestaurant(@Valid @RequestBody RestaurantRequest request){
        RestaurantResponse createdRestaurant = restaurantService.createRestaurant(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
    }

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants(){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getAllRestaurants());
    }

    @PutMapping("/updateRestaurant/{id}")
    public ResponseEntity<Restaurant> updateRestaurant
            (@PathVariable Long id, @Valid @RequestBody RestaurantRequest request){
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, request);
        if(updatedRestaurant!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedRestaurant);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deleteRestaurant/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id){
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Restaurant was successfully deleted");
    }
}
