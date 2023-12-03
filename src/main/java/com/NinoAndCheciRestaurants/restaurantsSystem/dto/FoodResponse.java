package com.NinoAndCheciRestaurants.restaurantsSystem.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by alexander.yordanov on 2023-12-03.
 */

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
