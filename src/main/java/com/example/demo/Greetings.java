package com.example.demo;

import lombok.Getter;

@Getter
public class Greetings {
  private final long id;
  private final String content;

  public Greetings() {
    this.id = -1;
    this.content = "";
  }

  public Greetings(long id, String content) {
    this.id = id;
    this.content = content;
  }

}
