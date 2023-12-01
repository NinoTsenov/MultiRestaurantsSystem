package com.NinoAndCheciRestaurants.restaurantsSystem.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryRequest {

    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryDescription;

//    @NotNull
//    private Byte[] categoryBanner;
}
