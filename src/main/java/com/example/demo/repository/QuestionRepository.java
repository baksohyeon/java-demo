package com.example.demo.repository;

import com.example.demo.model.Question;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

  List<Question> findBySubject(String subject);

}
