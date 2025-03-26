package com.chinhdo.identity_service.controller;

import com.chinhdo.identity_service.dto.request.UserCreationRequest;
import com.chinhdo.identity_service.entity.User;
import com.chinhdo.identity_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users") //endpoint
    User createUser(@RequestBody UserCreationRequest request){//map data body vao UsercreationRequest
        return userService.createUser(request);
    }
}
