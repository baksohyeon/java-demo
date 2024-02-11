package com.example.demo.answer;

import com.example.demo.answer.dto.CreateAnswerReqDto;
import com.example.demo.answer.model.Answer;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("answer")
@RestController
public class AnswerController {

  private final AnswerService answerService;

  public AnswerController(AnswerService answerService) {
    this.answerService = answerService;
  }


  @PostMapping(path = "/add")
  public Answer createAnswerToQuestion(@RequestParam Integer id,
      @RequestBody CreateAnswerReqDto createAnswerReqDto) {
    return this.answerService.createAnswerToQuestion(id, createAnswerReqDto);
  }

  // 질문 데이터를 통해 답변 데이터 찾기
  @GetMapping(path = "/related")
  public List<Answer> getAnswersOfQuestion(@RequestParam Integer questionId) {
    return this.answerService.getAnswersOfQuestion(questionId);
  }
}
