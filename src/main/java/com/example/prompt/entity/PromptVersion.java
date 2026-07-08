package com.example.prompt.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "prompt_versions")
public class PromptVersion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String versionName;
    private Long templateId;

      
    public PromptVersion()
    {
        
    }
    public PromptVersion(Long id, String versionName, String promptText, Long templateId) {
        this.id = id;
        this.versionName = versionName;
        this.promptText = promptText;
        this.templateId = templateId;
    }

    @Column(length = 1000)
    private String promptText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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