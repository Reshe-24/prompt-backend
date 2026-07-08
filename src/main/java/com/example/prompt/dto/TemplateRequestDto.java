package com.example.prompt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TemplateRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Prompt text is required")
    private String promptText;

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    public TemplateRequestDto() {
    }

    public TemplateRequestDto(String title, String promptText, String status,
                              Long userId, Long categoryId) {
        this.title = title;
        this.promptText = promptText;
        this.status = status;
        this.userId = userId;
        this.categoryId = categoryId;
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