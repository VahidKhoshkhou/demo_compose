package com.example.demo.service;

import com.example.demo.model.Student;

public interface StudentService {
	
	public  Iterable<Student> getAllStudents();
	public Student getStudentById(Long id);
	public Student addStudent(Student student);
	public void updateStudent(Student student,Long id);
	public void deleteStudent(Long id);
	public Student getStudentByNameAndSurname(String name,String surname);
}
