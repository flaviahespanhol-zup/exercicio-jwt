package com.exercicio.jwt.controllers;

import com.exercicio.jwt.dtos.AuthResponseDto;
import com.exercicio.jwt.dtos.PostLoginDto;
import com.exercicio.jwt.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public ResponseEntity<AuthResponseDto> loginController(@RequestBody PostLoginDto newLogin){

        String token = loginService.loginService(newLogin);

        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);

        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }


}
