package com.NinoAndCheciRestaurants.restaurantsSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Categories")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String categoryDescription;

//    @NotNull
//    private Byte[] categoryBanner;


}
