package com.example.prompt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prompt.entity.PromptCollection;

@Repository
public interface PromptCollectionRepository extends JpaRepository<PromptCollection, Long> {

}
