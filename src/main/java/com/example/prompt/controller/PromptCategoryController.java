package com.example.prompt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.prompt.dto.CategoryRequestDto;
import com.example.prompt.entity.PromptCategory;
import com.example.prompt.service.PromptCategoryService;

@RestController
@RequestMapping("/api/categories")
public class PromptCategoryController {

    @Autowired
    private PromptCategoryService service;

    @PreAuthorize("hasAuthority('TEAM_LEAD')")
    @PostMapping("/create")
    public PromptCategory saveCategory(@RequestBody CategoryRequestDto dto) {
        return service.saveCategory(dto);
    }

    @GetMapping
    public List<PromptCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public PromptCategory getCategoryById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @PreAuthorize("hasAuthority('TEAM_LEAD')")
    @PutMapping("/{id}")
    public PromptCategory updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDto dto) {
        return service.updateCategory(id, dto);
    }

    @PreAuthorize("hasAuthority('TEAM_LEAD')")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return service.deleteCategory(id);
    }
}