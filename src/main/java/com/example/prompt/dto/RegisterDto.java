package com.example.prompt.dto;

import com.example.prompt.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterDto {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String passwordHash;

    private Role role;

    public RegisterDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}