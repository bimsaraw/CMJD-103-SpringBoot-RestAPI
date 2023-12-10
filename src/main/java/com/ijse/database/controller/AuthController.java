package com.ijse.database.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    
    @GetMapping("/auth/login") 
    public String login() {
        return "Login works without authentication";
    }
}