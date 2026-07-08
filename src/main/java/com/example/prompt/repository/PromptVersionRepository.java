package com.example.prompt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prompt.entity.PromptVersion;

@Repository
public interface PromptVersionRepository extends JpaRepository<PromptVersion, Long> {

}