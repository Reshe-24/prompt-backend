package com.example.prompt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prompt.dto.VersionRequestDto;
import com.example.prompt.entity.PromptVersion;
import com.example.prompt.exception.ResourceNotFoundException;
import com.example.prompt.repository.PromptVersionRepository;

@Service
public class PromptVersionService {

    @Autowired
    private PromptVersionRepository repository;

    public PromptVersion addVersion(VersionRequestDto dto) {

        PromptVersion version = new PromptVersion();

        version.setVersionName(dto.getVersionName());
        version.setPromptText(dto.getPromptText());
        version.setTemplateId(dto.getTemplateId());

        return repository.save(version);
    }

    public List<PromptVersion> getAllVersions() {
        return repository.findAll();
    }

    public PromptVersion getVersionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Version not found"));
    }

    public PromptVersion updateVersion(Long id, VersionRequestDto dto) {

        PromptVersion existing = getVersionById(id);

        existing.setVersionName(dto.getVersionName());
        existing.setPromptText(dto.getPromptText());
        existing.setTemplateId(dto.getTemplateId());

        return repository.save(existing);
    }

    public String deleteVersion(Long id) {

        PromptVersion version = getVersionById(id);

        repository.delete(version);

        return "Version deleted successfully";
    }
}