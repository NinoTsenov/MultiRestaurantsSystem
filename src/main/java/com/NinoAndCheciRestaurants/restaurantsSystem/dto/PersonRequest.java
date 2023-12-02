package com.NinoAndCheciRestaurants.restaurantsSystem.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class PersonRequest {

    @NotBlank
    private String personName;

    @NotBlank
    private String personPhone;

}
