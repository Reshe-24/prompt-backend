package com.example.prompt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.prompt.dto.VersionRequestDto;
import com.example.prompt.entity.PromptVersion;
import com.example.prompt.service.PromptVersionService;

@RestController
@RequestMapping("/api/versions")
public class PromptVersionController {

    @Autowired
    private PromptVersionService service;

    @PreAuthorize("hasAuthority('TEAM_LEAD')")
    @PostMapping
    public PromptVersion addVersion(@RequestBody VersionRequestDto dto) {
        return service.addVersion(dto);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<PromptVersion> getAllVersions() {
        return service.getAllVersions();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public PromptVersion getVersionById(@PathVariable Long id) {
        return service.getVersionById(id);
    }

    @PreAuthorize("hasAuthority('TEAM_LEAD')")
    @PutMapping("/{id}")
    public PromptVersion updateVersion(@PathVariable Long id, @RequestBody VersionRequestDto dto) {
        return service.updateVersion(id, dto);
    }

    @PreAuthorize("hasAuthority('TEAM_LEAD')")
    @DeleteMapping("/{id}")
    public String deleteVersion(@PathVariable Long id) {
        return service.deleteVersion(id);
    }
}