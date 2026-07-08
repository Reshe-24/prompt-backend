package com.example.prompt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.prompt.dto.TemplateRequestDto;
import com.example.prompt.entity.PromptTemplate;
import com.example.prompt.service.PromptTemplateService;

@RestController
@RequestMapping("/api/templates")
public class PromptTemplateController {

    @Autowired
    private PromptTemplateService service;

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public PromptTemplate addTemplate(@RequestBody TemplateRequestDto dto) {
        return service.addTemplate(dto);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<PromptTemplate> getAllTemplates() {
        return service.getAllTemplates();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public PromptTemplate getTemplateById(@PathVariable Long id) {
        return service.getTemplateById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{id}")
    public PromptTemplate updateTemplate(@PathVariable Long id, @RequestBody TemplateRequestDto dto) {
        return service.updateTemplate(id, dto);
    }

    @PreAuthorize("hasAuthority('TEAM_LEAD')")
    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable Long id) {
        service.deleteTemplate(id);
    }
    
}
