package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.MissingAtrributeException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	
	public Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id) {
		Student s= studentRepository.findOne(id);
		if(s==null ) {
			 throw new StudentNotFoundException("Student Does not Exist");
		}
		return s;
	}
	
	public Student addStudent(Student student) {
		
		 return studentRepository.save(student);
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
