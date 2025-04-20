package com.virasat.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.virasat.user_service.DTOs.LoginDTO;
import com.virasat.user_service.models.JWTDescription;
import com.virasat.user_service.utils.*;

@RestController
public class AuthController {

    @Autowired
    private JWTUtils utilities;

    @GetMapping("/signup")
    public ResponseEntity<String> hello() {
        
        return ResponseEntity.ok("SignedUp!");
    }

}