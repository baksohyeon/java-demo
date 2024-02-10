package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "question")
public class QuestionController {

  private final QuestionRepository questionRepository;


  @GetMapping(path = "/all")
  public Iterable<Question> getAllQuestions() {
    return this.questionRepository.findAll();
  }

  @GetMapping(path = "/category")
  public List<Question> getQuestionBySubject(@RequestParam String subject) {
    return this.questionRepository.findBySubject(subject);
  }

  @GetMapping(path = "/like")
  public List<Question> getQuestionBySubjectLike(@RequestParam String subject) {
    return this.questionRepository.findBySubjectLike(String.format("%s%%", subject));
  }


  public QuestionController(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }
}
