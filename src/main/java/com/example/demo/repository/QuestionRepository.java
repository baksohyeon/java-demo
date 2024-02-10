package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

  Question findBySubject(String subject);
}
