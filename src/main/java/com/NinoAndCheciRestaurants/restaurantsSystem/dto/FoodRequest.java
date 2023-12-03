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
public class FoodRequest
{
    private String foodName;

    private String foodDescription;

    private Double price;

    private Long categoryId;
    private Long restaurantId;

    private List<Long> foodId;
    private String foodBanner;
}
