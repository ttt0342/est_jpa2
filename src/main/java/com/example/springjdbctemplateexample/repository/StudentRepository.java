package com.example.springjdbctemplateexample.repository;

import com.example.springjdbctemplateexample.Domain.Student;

import java.util.List;

public interface StudentRepository {
    // 하나의 테이블의 정보를 가져옴
    // student가 테이블을 저장함

    List<Student> findAll(); // 학생의 모든 정보를 저장해 리스트의 형태로 출력하기 위해

    int insertStudent(Student student);
}
