package com.NinoAndCheciRestaurants.restaurantsSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Restaurants")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotNull
    private Double deliveryCost;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @NotNull
    private Double minimumOrderTotal;

    @NotBlank
    private String deliveryTime;

}
