package com.NinoAndCheciRestaurants.restaurantsSystem.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ReviewResponse {

    @NotNull
    private Long id;

    private Integer numberStars;

    private String comment;

    private String restaurant;

    private LocalDateTime createdAt;

  // TODO
  //  private User user;
}
