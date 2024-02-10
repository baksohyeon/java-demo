package com.example.demo.controller;

import com.example.demo.dto.CreateAnswerReqDto;
import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("answer")
@RestController
public class AnswerController {

  private final AnswerRepository answerRepository;
  private final QuestionRepository questionRepository;

  public AnswerController(AnswerRepository answerRepository,
      QuestionRepository questionRepository) {
    this.answerRepository = answerRepository;
    this.questionRepository = questionRepository;
  }

  @PostMapping(path = "add")
  public Answer createAnswerToQuestion(@RequestParam Integer id,
      @RequestBody CreateAnswerReqDto createAnswerReqDto) {
    Optional<Question> partialQuestion = this.questionRepository.findById(id);
    if (partialQuestion.isPresent()) {
      Question question = partialQuestion.get();

      Answer answer = new Answer();
      answer.setContent(createAnswerReqDto.getContent());
      answer.setQuestion(question);

      return this.answerRepository.save(answer);

    }
    return null;
  }
}
