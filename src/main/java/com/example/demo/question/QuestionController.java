package com.example.demo.question;

import com.example.demo.question.dto.CreateQuestionReqDto;
import com.example.demo.question.dto.UpdateQuestionReqDto;
import com.example.model.Question;
import com.example.repository.QuestionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "question")
public class QuestionController {

  private final QuestionRepository questionRepository;

  public QuestionController(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }


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
    return this.questionRepository.findBySubjectLike(String.format("%%%s%%", subject));
  }

  @PostMapping("/post")
  public Question createQuestion(@RequestBody CreateQuestionReqDto reqDto) {
    Question question = new Question();
    question.setSubject(reqDto.getSubject());
    question.setContent(reqDto.getContent());
    return this.questionRepository.save(question);
  }

  @PutMapping(path = "/change")
  public Question updateSubjectById(@RequestParam Integer id,
      @RequestBody UpdateQuestionReqDto reqDto) {

    Optional<Question> partialQuestion = this.questionRepository.findById(id);
    if (partialQuestion.isPresent()) {
      Question question = partialQuestion.get();
      question.setSubject(reqDto.getSubject());
      question.setContent(reqDto.getContent());
      this.questionRepository.save(question);
      return question;
    }
    return null;
  }

  // 질문 데이터 삭제
  @DeleteMapping(path = "delete")
  public String deleteQuestionById(@RequestParam Integer id) {
    Optional<Question> partialQuestion = this.questionRepository.findById(id);
    if (partialQuestion.isPresent()) {
      Question question = partialQuestion.get();
      this.questionRepository.delete(question);
    }
    return "ok";
  }
}
