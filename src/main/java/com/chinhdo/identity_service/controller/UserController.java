package com.chinhdo.identity_service.controller;

import com.chinhdo.identity_service.dto.request.UserCreationRequest;
import com.chinhdo.identity_service.dto.request.UserUpdateRequest;
import com.chinhdo.identity_service.entity.User;
import com.chinhdo.identity_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") //ko can phai khai bao endpoint khi co annotation nay
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping //endpoint
    User createUser(@RequestBody UserCreationRequest request){//map data body vao UsercreationRequest
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId){ //map userId endpoint vao bien parameter
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return userService.updateUser(userId,request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted =)) ";
    }
}
