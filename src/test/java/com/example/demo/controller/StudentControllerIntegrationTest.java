package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {

	@Autowired
	private StudentController studentController;
	
	@Test
	public void testAddStudentHappyPath() {
		// create a student
    	Student student  = new Student("bbb","aaa",25);
    	
    	
    	 ResponseEntity<String> outCome= studentController.addStudent(student);
	     assertThat(outCome.getBody(),is(equalTo("student "+ student.getName()+" "+ student.getSurname()+" has been added correctly")));
	     assertThat(outCome.getStatusCode(),is(equalTo(HttpStatus.OK)));
	}
	
	@Test
	public void testAddStudentNameIsMissing() {
		// create a student
    	Student student  = new Student();
    	student.setSurname("bb");
    	student.setStudentAge(3);
    	 ResponseEntity<String> outCome= studentController.addStudent(student);
	     assertThat(outCome.getBody(),is(equalTo("The field name is missing")));
	     assertThat(outCome.getStatusCode(),is(equalTo(HttpStatus.BAD_REQUEST)));
	}
}
