package com.example.demo.answer;


import com.example.demo.answer.dto.CreateAnswerReqDto;
import com.example.model.Answer;
import com.example.repository.AnswerRepository;
import com.example.repository.QuestionRepository;
import com.example.model.Question;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AnswerService {

  private final AnswerRepository answerRepository;
  private final QuestionRepository questionRepository;

  @Autowired
  public AnswerService(AnswerRepository answerRepository,
      QuestionRepository questionRepository) {
    this.answerRepository = answerRepository;
    this.questionRepository = questionRepository;
  }

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

  // 질문 데이터를 통해 답변 데이터 찾기
  public List<Answer> getAnswersOfQuestion(@RequestParam Integer id) {
    Optional<Question> partialQuestion = this.questionRepository.findById(id);
    if (partialQuestion.isPresent()) {
      Question question = partialQuestion.get();
      return question.getAnswerList();
    }
    return Collections.emptyList();
  }

}
