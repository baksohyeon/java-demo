package com.example.demo.question;

import com.example.demo.question.dto.CreateQuestionReqDto;
import com.example.demo.question.dto.UpdateQuestionReqDto;
import com.example.demo.question.model.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

  private final QuestionService questionService;

  @Autowired
  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }


  @GetMapping(path = "/all")
  public Iterable<Question> getAllQuestions() {
    return this.questionService.getAllQuestions();
  }

  @GetMapping(path = "/category")
  public List<Question> getQuestionBySubject(@RequestParam String subject) {
    return this.questionService.getQuestionBySubject(subject);
  }

  @GetMapping(path = "/like")
  public List<Question> getQuestionBySubjectLike(@RequestParam String subject) {
    return this.questionService.getQuestionBySubjectLike(subject);
  }

  @PostMapping("/post")
  public Question createQuestion(@RequestBody CreateQuestionReqDto reqDto) {
    return this.questionService.createQuestion(reqDto);
  }

  @PutMapping(path = "/change")
  public Question updateSubjectById(@RequestParam Integer id,
      @RequestBody UpdateQuestionReqDto reqDto) {
    return this.questionService.updateSubjectById(id, reqDto);

  }

  // 질문 데이터 삭제
  @DeleteMapping(path = "delete")
  public String deleteQuestionById(@RequestParam Integer id) {
    return this.questionService.deleteQuestionById(id);
  }
}
