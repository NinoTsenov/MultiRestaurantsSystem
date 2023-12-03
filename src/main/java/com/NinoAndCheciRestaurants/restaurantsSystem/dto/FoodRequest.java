package com.NinoAndCheciRestaurants.restaurantsSystem.dto;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodRequest
{
    private String foodName;

    private String foodDescription;

    private Double price;

    private Long categoryId;

 //   private Long restaurantId;


    private String foodBanner;
}
