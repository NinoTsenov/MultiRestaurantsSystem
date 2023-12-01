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

//    @NotNull
//    private Byte[] foodBanner;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<Extra> ExtrasList = new ArrayList<>();


}
