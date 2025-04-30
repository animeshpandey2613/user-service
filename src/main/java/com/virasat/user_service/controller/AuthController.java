package com.virasat.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.virasat.user_service.DTOs.LoginDTO;
import com.virasat.user_service.DTOs.SignupDTO;
import com.virasat.user_service.models.JWTDescription;
import com.virasat.user_service.service.AuthenticationLogic;
import com.virasat.user_service.utils.*;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationLogic authenticationLogic;

    public AuthController(AuthenticationLogic authenticationLogic) {
        this.authenticationLogic = authenticationLogic;
    }

    @GetMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupDTO userDto) {
        String token = authenticationLogic.addNewUser(userDto);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/verifytoken")
    public void verifyToken(@RequestHeader("Authorization") String token) {
        authenticationLogic.verifyToken(token);
    }

}