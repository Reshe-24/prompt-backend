package com.example.prompt.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "prompt_categories")
public class PromptCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

     @Column(length = 500)
    private String description;

     @Column(name = "template_count")
    private Integer templateCount = 0;
    
    public PromptCategory() {
}
    
      public PromptCategory(Long id, String name, String description, Integer templateCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.templateCount = templateCount;
    }

    public Long getId() {
        return id;
    }

     public void setId(Long id) {
         this.id = id;
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

     public Integer getTemplateCount() {
         return templateCount;
     }

     public void setTemplateCount(Integer templateCount) {
         this.templateCount = templateCount;
     }

 

  
}