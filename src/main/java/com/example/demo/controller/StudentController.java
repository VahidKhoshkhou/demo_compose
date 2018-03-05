package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private StudentService service;

	@ApiOperation(value = "getListOfStudent", notes = "get all students", nickname = "getListOfStudent")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Student> getListOfStudent() {
		return service.getAllStudents();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") Long id) {
		return service.getStudentById(id);
	}
	
	@RequestMapping(value = "/{name}/{surname}", method = RequestMethod.GET)
	public Student getStudentByNameAndSurname(@PathVariable("name") String name,
			                        @PathVariable("surname") String surname) {
		return service.getStudentByNameAndSurname(name,surname);
	}


	@RequestMapping(value = "", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student) {
		service.addStudent(student);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateStudent( @PathVariable("id") Long id,@RequestBody Student student) {
		service.updateStudent(student, id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") Long id) {
		service.deleteStudent(id);
	}

}
