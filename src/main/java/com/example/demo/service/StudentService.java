package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    
	@Autowired
	 private StudentRepository studentRepository;
	
	
	public List<Student> getAllStudents() {
		List<Student> students=new ArrayList<>();
				studentRepository.findAll()
				     .forEach(students::add);
		return students;
	}
	
	public Student getStudentById(Long id) {
		Student s= studentRepository.findOne(id);
		return s;
	}
	
	public void addStudent(Student student) {
		 studentRepository.save(student);
	}

	public void updateStudent(Student student,Long id) {
		 studentRepository.save(student);
		
	}
	
	public void deleteStudent(Long id) {
		 studentRepository.delete(id);		
	}

	public Student getStudentByNameAndSurname(String name,String surname) {		
		return studentRepository.findByNameAndSurname(name,surname);
	}
	
}
