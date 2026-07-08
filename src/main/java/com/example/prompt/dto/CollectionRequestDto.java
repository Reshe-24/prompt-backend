package com.example.prompt.dto;

import jakarta.validation.constraints.NotBlank;

public class CollectionRequestDto {

    @NotBlank(message = "Collection name is required")
    private String collectionName;

    private String description;

    private Long userId;

    public CollectionRequestDto() {
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}