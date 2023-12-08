package com.NinoAndCheciRestaurants.restaurantsSystem.dto;

import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Review;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RestaurantResponse {

    private Long id;

    @NotBlank
    private String restaurantName;

    @NotBlank
    private String restaurantDescription;

    @NotBlank
    private String restaurantAddress;

    @NotBlank
    private String restaurantPhoneNumber;

    @NotBlank
    private String restaurantEmail;

    //  private Byte[] restaurantBanner;

    private Double rating;
}
