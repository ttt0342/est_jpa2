package com.example.springjdbctemplateexample.repository;

import com.example.springjdbctemplateexample.Domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentJdbcTemplateRepository implements StudentRepository {
  private final JdbcTemplate jdbcTemplate;

  public StudentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Student> findAll() {
    return jdbcTemplate.query(
        "select * from students",
        (rs, rowNum) ->
            new Student(
                rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("address")));
  }

  @Override
  public int insertStudent(Student student) {
    return jdbcTemplate.update(
        "insert into students(id, name, age, address) values(?,?,?,?)",
        student.getId(),
        student.getName(),
        student.getAge(),
        student.getAddress());
  }

  // 기능제공 확인해보기 - jdbc템플릿에서 네임드 파라미터 jdbc 템플릿 활용해보기
  // ? 대신 네임드파라미터 사용하기
//  @Override
//  public List<Student> findStudents(String name) {
//    MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource().addValue("name", name);
//    return jdbcTemplate.query("SELECT * FROM students WHERE name = :name",
//            mapSqlParameterSource,
//            (rs, rowNum) -> new Student(rs.getLong("id"), rs.getString("name"),
//                    rs.getInt("age"), rs.getString("address"), rs.getDate("created_at")));
//  }
}
