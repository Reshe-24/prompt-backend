package com.example.prompt.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "prompt_templates")
public class PromptTemplate {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String promptText;

    private String status;

    private Long userId;

    private Long categoryId;

     public PromptTemplate()
     {
        
     }
    
    public PromptTemplate(Long id, String title, String promptText, String status, Long userId, Long categoryId) {
        this.id = id;
        this.title = title;
        this.promptText = promptText;
        this.status = status;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

 
}