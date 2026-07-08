package com.example.prompt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prompt.dto.TemplateRequestDto;
import com.example.prompt.entity.PromptTemplate;
import com.example.prompt.exception.ResourceNotFoundException;
import com.example.prompt.repository.PromptTemplateRepository;

@Service
public class PromptTemplateService {

    @Autowired
    private PromptTemplateRepository repository;

    public PromptTemplate addTemplate(TemplateRequestDto dto) {

        PromptTemplate template = new PromptTemplate();

        template.setTitle(dto.getTitle());
        template.setPromptText(dto.getPromptText());
        template.setStatus(dto.getStatus());
        template.setUserId(dto.getUserId());
        template.setCategoryId(dto.getCategoryId());

        return repository.save(template);
    }

    public List<PromptTemplate> getAllTemplates() {
        return repository.findAll();
    }
 

    public PromptTemplate getTemplateById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Template not found"));
    }

    public PromptTemplate updateTemplate(Long id, TemplateRequestDto dto) {

        PromptTemplate existing = getTemplateById(id);

        existing.setTitle(dto.getTitle());
        existing.setPromptText(dto.getPromptText());
        existing.setStatus(dto.getStatus());
        existing.setUserId(dto.getUserId());
        existing.setCategoryId(dto.getCategoryId());

        return repository.save(existing);
    }

    public String deleteTemplate(Long id) {

        PromptTemplate template = getTemplateById(id);

        repository.delete(template);

        return "Template deleted successfully";
    }
}