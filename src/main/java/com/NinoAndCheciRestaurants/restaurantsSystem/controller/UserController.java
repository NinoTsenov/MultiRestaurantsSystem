package com.NinoAndCheciRestaurants.restaurantsSystem.controller;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.UserRequest;
import com.NinoAndCheciRestaurants.restaurantsSystem.dto.UserResponse;
import com.NinoAndCheciRestaurants.restaurantsSystem.entity.User;
import com.NinoAndCheciRestaurants.restaurantsSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request){
        UserResponse createdUser = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser
            (@PathVariable Long id, @Valid @RequestBody UserRequest request){
        User updatedUser = userService.updateUser(id, request);
        if(updatedUser!=null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
        }
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.GONE).body("User was successfully deleted");
    }
}
