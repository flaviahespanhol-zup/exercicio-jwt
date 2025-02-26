package com.exercicio.jwt.controllers;

import com.exercicio.jwt.dtos.PostUserDto;
import com.exercicio.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registerUserController(@RequestBody PostUserDto newUser) {
        userService.registerUserService(newUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public Map<String, String> showAccess(){
        return Map.of("message", "Você acessou o endpoint GET /user");
    }
}
