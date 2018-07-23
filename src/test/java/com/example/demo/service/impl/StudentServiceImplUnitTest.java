package com.example.demo.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.Impl.StudentServiceImpl;
import com.google.common.collect.Iterables;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class StudentServiceImplUnitTest {
	
	@Mock
	private StudentRepository studentRepoMock;
	
	@InjectMocks
	private StudentServiceImpl studentService;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllStudentsCheck() {
		// preparation
		when(studentRepoMock.findAll()).thenReturn(Arrays.asList(new Student("aaa","bbb",25),
	    		new Student("ccc","bbb",17),
	    		new Student("ddd","eee",23)));
		// verify
		assertNotNull(studentService.getAllStudents());
		assertEquals(3,Iterables.size(studentService.getAllStudents()));
		assertEquals("ddd",Iterables.getLast(studentService.getAllStudents()).getName());
		assertEquals("eee",Iterables.getLast(studentService.getAllStudents()).getSurname());
	}
	
	@Test
	public void throwStudentNotFoundException() {		
		when(studentRepoMock.findOne(new Long(2))).thenReturn(new Student());	
		try {
			studentService.getStudentById(new Long(6));
			fail("StudentNotFoundException should have been thrown");
		}catch(Exception ex) {
			assertEquals(ex.getMessage(), "Student Does not Exist");
		}
		
	}
	
	@Test
	public void testAddStudent() {
		// create a student
    	Student studentMock = new Student("bbb","aaa",25);
    	
    	when(studentRepoMock.save(any(Student.class))).thenReturn(studentMock);
    	// test adding a new student                    
    	Student newStudent= studentService.addStudent(null); 
    	
    	// verify
    	assertNotNull(newStudent);	
    	assertEquals( "bbb", newStudent.getName());
	}
}
