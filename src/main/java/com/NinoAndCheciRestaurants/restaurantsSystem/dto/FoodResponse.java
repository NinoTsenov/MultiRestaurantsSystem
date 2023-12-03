package com.NinoAndCheciRestaurants.restaurantsSystem.dto;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodResponse
{
    private Long id;

    private String foodName;

    private String foodDescription;

    private Double price;

    private String foodBanner;


    private CategoryResponse category;
    // TODO
//    private RestaurantResponse restaurant;

    private List<FoodResponse> food;
}
