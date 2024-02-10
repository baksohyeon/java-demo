package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "question")
public class QuestionController {

  private final QuestionRepository questionRepository;


  @GetMapping(path = "/all")
  public @ResponseBody Iterable<Question> getAllQuestions() {
    return this.questionRepository.findAll();
  }

  @GetMapping(path = "/category")
  public @ResponseBody Iterable<Question> getQuestionBySubject(@RequestParam String subject) {
    return this.questionRepository.findBySubject(subject);
  }

//  @ResponseBody
//  @PostMapping("/add")
//  public String createQuestion(@RequestBody HashMap<String, String> req) {
//    Question question = new Question();
//    question.setSubject(req.get);
//    question.setContent(content);
//    questionRepository.save(question);
//    return "ok";
//  }

  public QuestionController(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }
}
