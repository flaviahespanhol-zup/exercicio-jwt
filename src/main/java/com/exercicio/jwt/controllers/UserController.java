package com.exercicio.jwt.controllers;

import com.exercicio.jwt.dtos.PostUserDto;
import com.exercicio.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registerUserController(@RequestBody PostUserDto newUser) {
        userService.registerUserService(newUser);
    }
}
