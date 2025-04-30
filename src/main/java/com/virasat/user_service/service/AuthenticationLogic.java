package com.virasat.user_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.virasat.user_service.utils.JWTDescriptionBuilder;
import com.virasat.user_service.DTOs.SignupDTO;
import com.virasat.user_service.models.JWTDescription;
import com.virasat.user_service.utils.JWTUtils;
import com.virasat.user_service.Enums.Issuer;

@Service
public class AuthenticationLogic {
    private JWTDescriptionBuilder jwtDescriptionBuilder;
    private JWTUtils jwtUtils;

    public AuthenticationLogic(JWTDescriptionBuilder jwtDescriptionBuilder, JWTUtils jwtUtils) {
        this.jwtDescriptionBuilder = jwtDescriptionBuilder;
        this.jwtUtils = jwtUtils;
    }

    public String addNewUser(SignupDTO userDto) {
        String role = userDto.getRole();
        String subRole = userDto.getSubRole();
        String userName = userDto.getUserName();
        JWTDescription description = jwtDescriptionBuilder
                .role(role)
                .userName(userName)
                .subRole(subRole)
                .build();
        return jwtUtils.generateToken(description, Issuer.Admin.getIssuer());
    }

    public void verifyToken(String token) {
        jwtUtils.getTokenClaims(Issuer.Admin.getIssuer(), token);
    }
}
