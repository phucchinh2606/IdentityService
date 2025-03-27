package com.chinhdo.identity_service.controller;

import com.chinhdo.identity_service.dto.request.ApiResponse;
import com.chinhdo.identity_service.dto.request.UserCreationRequest;
import com.chinhdo.identity_service.dto.request.UserUpdateRequest;
import com.chinhdo.identity_service.dto.response.UserResponse;
import com.chinhdo.identity_service.entity.User;
import com.chinhdo.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") //ko can phai khai bao endpoint khi co annotation nay
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping //endpoint
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        //map data body vao UsercreationRequest, valid theo rule trong UserCreationRequest

        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String userId){ //map userId endpoint vao bien parameter
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted =)) ";
    }
}
