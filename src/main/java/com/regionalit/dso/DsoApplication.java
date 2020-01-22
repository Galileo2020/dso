package com.regionalit.dso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DsoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DsoApplication.class, args);
  }

  @GetMapping("")
  String hello() {
    return "hello, the time is 2020-01-23 00:12:08";
  }
}
