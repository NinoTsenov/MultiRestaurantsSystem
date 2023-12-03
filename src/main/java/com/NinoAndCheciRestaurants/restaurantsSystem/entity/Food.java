package com.NinoAndCheciRestaurants.restaurantsSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "Foods")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String foodName;

    @NotBlank
    private String foodDescription;

    @NotNull
    private Double price;

    @NotNull
    private byte[] foodBanner;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Restaurant restaurant;


}
