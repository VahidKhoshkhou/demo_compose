package com.example.demo.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Student;
import com.example.demo.service.Impl.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class StudentServiceImplIntegrationTest {
    @Autowired
	private StudentServiceImpl studentServiceImpl;
    
    @Test
    public void testAStudentHappyPath() {
    	// create a student
    	Student student = new Student("bbb","aaa",25);
    	
    	// test adding a new student
    	Student newStudent= studentServiceImpl.addStudent(student);
    	
    	// verify
    	assertNotNull(newStudent);
    	assertNotNull(newStudent.getId());    	
    	assertEquals( "bbb", newStudent.getName());
    	    
    }
}
