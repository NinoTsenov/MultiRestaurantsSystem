package com.NinoAndCheciRestaurants.restaurantsSystem.dto;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Restaurant;
import lombok.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReviewRequest {

    @Min(value = 1)
    @Max(value = 5)
    private Integer numberStars;

    @NotBlank
    private String comment;

    @NotNull
    private Restaurant restaurant;

    @NotNull
    private LocalDateTime createdAt;

//TODO
//    private User user;
}
