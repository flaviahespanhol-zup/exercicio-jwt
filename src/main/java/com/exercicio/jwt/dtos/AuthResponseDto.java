package com.exercicio.jwt.dtos;

public class AuthResponseDto {
    private String accessToken;

    public AuthResponseDto() {}

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
