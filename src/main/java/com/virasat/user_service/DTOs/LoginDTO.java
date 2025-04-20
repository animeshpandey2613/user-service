package com.virasat.user_service.DTOs;

public class LoginDTO {
    private int username;
    private int password;
    public LoginDTO(int username, int password){
        this.username = username;
        this.password = password;
    }
    public int getUsername(){
        return this.username;
    }
    public int getPassword(){
        return this.password;
    }
}
