package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @PutMapping(path = "/change")
  public Question updateSubjectById(@RequestParam Integer id) {
    Optional<Question> partialQuestion = this.questionRepository.findById(id);
    if (partialQuestion.isPresent()) {
      Question question = partialQuestion.get();
      question.setSubject("수정된 제목!");
      question.setContent("수정된 내용!");
      this.questionRepository.save(question);
      return question;
    }
    return null;
  }



  public QuestionController(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }
}
