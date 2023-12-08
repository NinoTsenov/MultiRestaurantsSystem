package com.NinoAndCheciRestaurants.restaurantsSystem.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import javax.validation.constraints.NotBlank;
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

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Review> reviews;

}
