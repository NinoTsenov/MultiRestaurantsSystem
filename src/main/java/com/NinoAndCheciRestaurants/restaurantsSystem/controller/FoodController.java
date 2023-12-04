package com.NinoAndCheciRestaurants.restaurantsSystem.controller;

import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.FoodResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
@RequiredArgsConstructor

public class FoodController
{

    private final FoodService foodService;

    @PostMapping("/createFood")
    public ResponseEntity<FoodResponse> createFood(@Valid @RequestBody FoodRequest request){
        FoodResponse createdFood = foodService.createFood(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    @GetMapping("/getAllFood")
    public ResponseEntity<List<FoodResponse>> getAllFoods(){
        return ResponseEntity.status(HttpStatus.OK).body(foodService.getAllFoods());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FoodResponse> updateFood
            (@PathVariable Long id, @Valid @RequestBody FoodRequest request){
        FoodResponse updatedFood = foodService.updateFood(id, request);
        if(updatedFood!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedFood);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id){
        foodService.deleteFoodById(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Food was successfully deleted");
    }
}
