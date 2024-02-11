package com.example.demo.question;

import com.example.demo.question.model.Question;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

  List<Question> findBySubject(String subject);

  List<Question> findBySubjectLike(String subject);

}
