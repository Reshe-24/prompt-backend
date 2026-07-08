package com.example.prompt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.prompt.dto.AuthRequestDto;
import com.example.prompt.dto.AuthResponseDto;
import com.example.prompt.dto.RegisterDto;
import com.example.prompt.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public AuthResponseDto register(@RequestBody RegisterDto dto) {
        return service.register(dto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto dto) {
        return service.login(dto);
    }
}