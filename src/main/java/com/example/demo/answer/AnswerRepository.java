package com.example.demo.answer;

import com.example.demo.answer.model.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

}
