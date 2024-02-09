package com.example.demo;

import static java.lang.System.out;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @GetMapping("/greeting")
  public String greeting(@RequestParam(value = "name", defaultValue = "World") String name,
      Model model) {
    model.addAttribute("name", name);
    return "greeting";
  }


  @CrossOrigin(origins = "http://localhost:9000")
  @GetMapping("greetings")
  public Greetings greetings(@RequestParam(required = false, defaultValue = "World") String name) {
    out.println("==== get greeting ====");
    return new Greetings(counter.incrementAndGet(), String.format(template, name));
  }

  @GetMapping("/greetings-java-config")
  public Greetings greetingWithJavaConfig(
      @RequestParam(required = false, defaultValue = "World") String name) {
    out.println("==== in greeting ====");
    return new Greetings(counter.incrementAndGet(), String.format(template, name));
  }
}