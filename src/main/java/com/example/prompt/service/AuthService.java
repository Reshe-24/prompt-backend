package com.example.prompt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.prompt.dto.AuthRequestDto;
import com.example.prompt.dto.AuthResponseDto;
import com.example.prompt.dto.RegisterDto;
import com.example.prompt.entity.Role;
import com.example.prompt.entity.SystemUser;
import com.example.prompt.repository.SystemUserRepository;

@Service
public class AuthService {

    @Autowired
    private SystemUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public AuthResponseDto register(RegisterDto dto) {

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        SystemUser user = new SystemUser();

// Set username
user.setUsername(dto.getUsername());

// Set email
user.setEmail(dto.getEmail());

// Encrypt password
user.setPasswordHash(passwordEncoder.encode(dto.getPasswordHash()));

// Set role
if (dto.getRole() == null) {
    user.setRole(Role.TEAM_LEAD);
} else {
    user.setRole(dto.getRole());
}
        SystemUser savedUser = repository.save(user);

        String token = jwtService.generateToken(
                savedUser.getEmail(),
                List.of(savedUser.getRole().name()));

        return new AuthResponseDto(
                token,
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getRole());
    }

    public AuthResponseDto login(AuthRequestDto dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPasswordHash()));

        SystemUser dbUser = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(
                dbUser.getEmail(),
                List.of(dbUser.getRole().name()));

        return new AuthResponseDto(
                token,
                dbUser.getId(),
                dbUser.getEmail(),
                dbUser.getRole());
    }
}
