package com.virasat.user_service.models;

import java.util.Date;

import com.virasat.user_service.utils.JWTDescriptionBuilder;

public class JWTDescription {
    private String role;
    private String userName;
    private String subRole;

    public JWTDescription(JWTDescriptionBuilder builder){
        this.role = builder.getRole();
        this.subRole = builder.getSubRole();
        this.userName = builder.getUserName();
    }

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public String getSubRole() {
        return subRole;
    }
}
