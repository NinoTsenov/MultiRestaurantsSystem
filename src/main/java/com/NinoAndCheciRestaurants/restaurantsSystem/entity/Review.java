package com.NinoAndCheciRestaurants.restaurantsSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Reviews")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberStars;

    private String userComment;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    private User user;
}
