package com.example.prompt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prompt.dto.CollectionRequestDto;
import com.example.prompt.entity.PromptCollection;
import com.example.prompt.exception.ResourceNotFoundException;
import com.example.prompt.repository.PromptCollectionRepository;

@Service
public class PromptCollectionService {

    @Autowired
    private PromptCollectionRepository repository;

    public PromptCollection addCollection(CollectionRequestDto dto) {

        PromptCollection collection = new PromptCollection();

        collection.setCollectionName(dto.getCollectionName());
        collection.setDescription(dto.getDescription());
        collection.setUserId(dto.getUserId());

        return repository.save(collection);
    }

    public List<PromptCollection> getAllCollections() {
        return repository.findAll();
    }

    public PromptCollection getCollectionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Collection not found"));
    }

    public PromptCollection updateCollection(Long id, CollectionRequestDto dto) {

        PromptCollection existing = getCollectionById(id);

        existing.setCollectionName(dto.getCollectionName());
        existing.setDescription(dto.getDescription());
        existing.setUserId(dto.getUserId());

        return repository.save(existing);
    }

    public String deleteCollection(Long id) {

        PromptCollection collection = getCollectionById(id);

        repository.delete(collection);

        return "Collection deleted successfully";
    }
}