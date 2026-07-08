package com.example.prompt.dto;

public class CategoryRequestDto {

    private String name;
    private String description;
    private int templateCount;

    public CategoryRequestDto() {
    }

    public CategoryRequestDto(String name, String description, int templateCount) {
        this.name = name;
        this.description = description;
        this.templateCount = templateCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemplateCount() {
        return templateCount;
    }

    public void setTemplateCount(int templateCount) {
        this.templateCount = templateCount;
    }
}