package com.example.prompt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prompt.dto.CategoryRequestDto;
import com.example.prompt.entity.PromptCategory;
import com.example.prompt.exception.ResourceNotFoundException;
import com.example.prompt.repository.PromptCategoryRepository;

@Service
public class PromptCategoryService {

    @Autowired
    private PromptCategoryRepository repository;

    public PromptCategory saveCategory(CategoryRequestDto dto) {

        PromptCategory category = new PromptCategory();

        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setTemplateCount(dto.getTemplateCount());

        return repository.save(category);
    }

    public List<PromptCategory> getAllCategories() {
        return repository.findAll();
    }

    public PromptCategory getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with id : " + id));
    }

    public PromptCategory updateCategory(Long id, CategoryRequestDto dto) {

        PromptCategory existing = getCategoryById(id);

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setTemplateCount(dto.getTemplateCount());

        return repository.save(existing);
    }

    public String deleteCategory(Long id) {

        PromptCategory category = getCategoryById(id);

        repository.delete(category);

        return "Category deleted successfully";
    }
}