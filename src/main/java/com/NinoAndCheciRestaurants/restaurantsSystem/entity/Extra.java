package com.NinoAndCheciRestaurants.restaurantsSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Extras")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Extra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String extraName;

    @NotNull
    private  Integer extraWeight;

    @NotNull
    private Double extraPrice;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}
