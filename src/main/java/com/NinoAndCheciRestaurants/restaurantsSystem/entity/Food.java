package com.NinoAndCheciRestaurants.restaurantsSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Food> foodList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Restaurant restaurant;


}
