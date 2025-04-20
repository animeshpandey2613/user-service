package com.virasat.user_service.utils;

import org.springframework.stereotype.Component;

import com.virasat.user_service.models.*;
@Component
public class JWTDescriptionBuilder {
    private String role;
    private String userName;
    private String subRole;

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public String getSubRole() {
        return subRole;
    }

    public JWTDescriptionBuilder role(String role){
        this.role = role;
        return this;
    }

    public JWTDescriptionBuilder userName(String userName){
        this.userName = userName;
        return this;
    }

    public JWTDescriptionBuilder subRole(String subRole){
        this.subRole = subRole;
        return this;
    }

    public JWTDescription build(){
        return new JWTDescription(this);
    }
}
