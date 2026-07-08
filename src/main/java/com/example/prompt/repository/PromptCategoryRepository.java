package com.example.prompt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prompt.entity.PromptCategory;

@Repository
public interface PromptCategoryRepository extends JpaRepository<PromptCategory, Long> {

    boolean existsByName(String name);

}
