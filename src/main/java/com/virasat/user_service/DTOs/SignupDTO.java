package com.virasat.user_service.DTOs;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SignupDTO {
    private final String userName;
    private final String role;
    private final String subRole;
    private final String password;
    private final String email;
    private final String phoneNumber;
    
    @JsonCreator
    public SignupDTO(String userName, String role, String subRole, String password, String email, String phoneNumber) {
        this.userName = userName;
        this.role = role;
        this.subRole = subRole;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public String getSubRole() {
        return subRole;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
