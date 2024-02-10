package com.example.demo;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private QuestionRepository questionRepository;


  @Test
  void testDatabaseConnection() {
    Question question = new Question();
    question.setSubject("MVC 가 뭔가요?");
    question.setContent("방송국인가요? 답변 부탁드립니다.");
    question.setCreatedAt(LocalDateTime.now());
    this.questionRepository.save(question);

    Question anotherQuestion = new Question();
    anotherQuestion.setSubject("Spring Boot 가 뭔가요?");
    anotherQuestion.setContent("내공 100");
    anotherQuestion.setCreatedAt(LocalDateTime.now());
    this.questionRepository.save(anotherQuestion);
  }

}
