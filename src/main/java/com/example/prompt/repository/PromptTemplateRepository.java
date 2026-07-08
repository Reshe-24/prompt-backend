package com.example.prompt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prompt.entity.PromptTemplate;

@Repository
public interface PromptTemplateRepository extends JpaRepository<PromptTemplate, Long> {
 
}