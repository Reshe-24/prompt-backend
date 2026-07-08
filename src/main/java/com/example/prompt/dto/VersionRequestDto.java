package com.example.prompt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VersionRequestDto {

    @NotBlank(message = "Version name is required")
    private String versionName;

    @NotBlank(message = "Prompt text is required")
    private String promptText;

    @NotNull(message = "Template ID is required")
    private Long templateId;

    public VersionRequestDto() {
    }

    public VersionRequestDto(String versionName, String promptText, Long templateId) {
        this.versionName = versionName;
        this.promptText = promptText;
        this.templateId = templateId;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
}