package com.example.prompt.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "prompt_collections")
public class PromptCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collectionName;

    private String description;

    private Long userId;

    public PromptCollection() {
    }

       public PromptCollection(Long id, String collectionName, String description, Long userId) {
        this.id = id;
        this.collectionName = collectionName;
        this.description = description;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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