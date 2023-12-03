package com.NinoAndCheciRestaurants.restaurantsSystem.dto;
import lombok.*;
import java.util.List;

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
