package com.NinoAndCheciRestaurants.restaurantsSystem.dto;

import lombok.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;




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

//TODO
//    private User user;
}
