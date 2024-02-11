package com.example.demo.question;

import com.example.demo.question.dto.CreateQuestionReqDto;
import com.example.demo.question.dto.UpdateQuestionReqDto;
import com.example.demo.question.model.Question;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class QuestionService {

  private final QuestionRepository questionRepository;

  public QuestionService(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }


  public Iterable<Question> getAllQuestions() {
    return this.questionRepository.findAll();
  }

  public List<Question> getQuestionBySubject(@RequestParam String subject) {
    return this.questionRepository.findBySubject(subject);
  }

  public List<Question> getQuestionBySubjectLike(@RequestParam String subject) {
    return this.questionRepository.findBySubjectLike(String.format("%%%s%%", subject));
  }

  public Question createQuestion(@RequestBody CreateQuestionReqDto reqDto) {
    Question question = new Question();
    question.setSubject(reqDto.getSubject());
    question.setContent(reqDto.getContent());
    return this.questionRepository.save(question);
  }

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
  public String deleteQuestionById(@RequestParam Integer id) {
    Optional<Question> partialQuestion = this.questionRepository.findById(id);
    if (partialQuestion.isPresent()) {
      Question question = partialQuestion.get();
      this.questionRepository.delete(question);
    }
    return "ok";
  }
}
