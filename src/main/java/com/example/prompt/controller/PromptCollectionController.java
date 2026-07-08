package com.example.prompt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.prompt.dto.CollectionRequestDto;
import com.example.prompt.entity.PromptCollection;
import com.example.prompt.service.PromptCollectionService;

@RestController
@RequestMapping("/api/collections")
public class PromptCollectionController {

    @Autowired
    private PromptCollectionService service;

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public PromptCollection addCollection(@RequestBody CollectionRequestDto dto) {
        return service.addCollection(dto);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<PromptCollection> getAllCollections() {
        return service.getAllCollections();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public PromptCollection getCollectionById(@PathVariable Long id) {
        return service.getCollectionById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public String deleteCollection(@PathVariable Long id) {
        return service.deleteCollection(id);
    }
}