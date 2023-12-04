package com.NinoAndCheciRestaurants.restaurantsSystem.dto;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private Role role;
}
