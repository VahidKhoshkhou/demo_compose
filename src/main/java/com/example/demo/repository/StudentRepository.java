package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

  public Student findByName(String name);

  public Student findByNameAndSurname(String name, String surname);
}
