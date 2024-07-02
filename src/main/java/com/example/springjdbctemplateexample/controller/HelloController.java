package com.example.springjdbctemplateexample.controller;

import com.example.springjdbctemplateexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//  @Autowired
//  @Qualifier("studentJdbcTemplateRepository")
//  private StudentRepository studentRepository;
  // 테스트코드가 아닌 로컬에서 바로 확인하고 싶다면 사용하는 코드

  @GetMapping("/Hello")
  public String hi() {
    return "OK";
  }
}
