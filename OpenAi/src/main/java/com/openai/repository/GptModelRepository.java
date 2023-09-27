package com.openai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openai.entity.GptModel;

@Repository
public interface GptModelRepository extends JpaRepository<GptModel, Long> {

}
