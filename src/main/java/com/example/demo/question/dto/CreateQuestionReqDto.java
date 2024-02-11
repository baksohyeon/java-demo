package com.example.demo.question.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQuestionReqDto {
  private String subject;
  private String content;
}
