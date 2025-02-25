package com.exercicio.jwt.dtos;

public class PostLoginDto {
    private String username;
    private String password;

    public PostLoginDto() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
