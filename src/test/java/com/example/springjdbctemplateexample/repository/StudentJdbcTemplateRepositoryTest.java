package com.example.springjdbctemplateexample.repository;

import com.example.springjdbctemplateexample.Domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 테스트로 동일한 상태의 클래스 생성된다
// 테스트 코드이나 실제 DB에 반영이 된다.
@Repository
@SpringBootTest
// 이 어노테이션은 메인 코드에 있는 모든 빈들을 불러낸다
// 컨텍스트에 실제 등록이 된다. 그래서 테스트 안에서 빈을 사용할 수 있다.
class StudentJdbcTemplateRepositoryTest {
  @Autowired
  @Qualifier("studentJdbcTemplateRepository")
  private StudentRepository studentRepository;

  @Test
  void insertTest() {
    Student student = new Student();
    student.setName("장이수");
    student.setAge(41);
    student.setAddress("제주도");
    studentRepository.insertStudent(student);
  }

  // 테스트 코드는 데이터가 잘 들어갔는지 검증, 확인하기 위한 목적
  @Test
  void selectTest() {
    List<Student> List = studentRepository.findAll();
    for (Student student : List) {
      System.out.println(student.getId());
      System.out.println(student.getName());
      System.out.println(student.getAge());
      System.out.println(student.getAddress());
    }
  }
}
