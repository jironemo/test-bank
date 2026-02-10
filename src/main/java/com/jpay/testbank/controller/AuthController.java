package com.jpay.testbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpay.testbank.dto.ApiKeyResponseDto;
import com.jpay.testbank.service.auth.AuthService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;  
    public AuthController(@Autowired AuthService authService){
        this.authService = authService;
    }
    @GetMapping("generate-key")
    public ApiKeyResponseDto generateApiKey(@RequestParam Long userId) {
        ApiKeyResponseDto response = authService.generateApiKey(userId);
        return response;
    }
    
}
