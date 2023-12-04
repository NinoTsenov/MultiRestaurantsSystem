package com.NinoAndCheciRestaurants.restaurantsSystem.service.impl;
import com.NinoAndCheciRestaurants.restaurantsSystem.converter.UserConverter;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.UserRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.UserResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.User;
import com.NinoAndCheciRestaurants.restaurantsSystem.repository.UserRepository;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final UserConverter userConverter;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userConverter.createUser(request);
        User savedUser = userRepository.save(user);
        return userConverter.toUserResponse(savedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));

        if (user.getEmail() == null || request.getEmail()!=null) {
            user.setEmail(request.getEmail());
        }
        if (user.getFirstName() == null || request.getFirstName()!=null) {
            user.setFirstName(request.getFirstName());
        }
        if (user.getLastName() == null || request.getLastName()!=null) {
            user.setLastName(request.getLastName());
        }
        if (user.getPhoneNumber() == null || request.getPhoneNumber()!=null) {
            user.setPhoneNumber(request.getPhoneNumber());
        }
        return userRepository.save(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserResponse> allUsersResponse = new ArrayList<>();
        for (User u : allUsers){
            allUsersResponse.add(userConverter.toUserResponse(u));
        }
        return allUsersResponse;
    }
}
