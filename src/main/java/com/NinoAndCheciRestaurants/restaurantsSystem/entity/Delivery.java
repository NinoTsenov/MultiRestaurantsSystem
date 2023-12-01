package com.NinoAndCheciRestaurants.restaurantsSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "Deliveries")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @NotBlank
    private String address;

    private LocalDate date;

    @NotNull
    private Double fee;

    @NotBlank
    private String status;

    @NotBlank
    private String estimatedTime;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
