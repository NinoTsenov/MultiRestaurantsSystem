package com.NinoAndCheciRestaurants.restaurantsSystem.service;


import com.NinoAndCheciRestaurants.restaurantsSystem.dto.UserRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.UserResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.User;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);
    void deleteUserById (Long id);
    User updateUser (Long id, UserRequest request);
    List<UserResponse> getAllUsers();
}
