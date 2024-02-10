package com.example.demo.repository;

import com.example.demo.model.Question;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionRepositoryTest {

  @Autowired
  private QuestionRepository questionRepository;


  @Test
  void testDatabaseConnection() {
    Question question = new Question();
    question.setSubject("주제주제~1");
    question.setContent("내용내용~1");
    question.setCreatedAt(LocalDateTime.now());
    this.questionRepository.save(question);

    Question anotherQuestion = new Question();
    anotherQuestion.setSubject("주제주제~2");
    anotherQuestion.setContent("내용내용~2");
    anotherQuestion.setCreatedAt(LocalDateTime.now());
    this.questionRepository.save(anotherQuestion);
  }
}