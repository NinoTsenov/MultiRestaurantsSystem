package com.NinoAndCheciRestaurants.restaurantsSystem.converter;

import com.NinoAndCheciRestaurants.restaurantsSystem.dto.UserRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.UserResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class UserConverter {

    public User createUser (UserRequest request){
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .role(request.getRole())
                .build();
    }

    public UserResponse toUserResponse (User user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }
}
