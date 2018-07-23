package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.MissingAtrributeException;
import com.example.demo.model.Student;
import com.example.demo.service.Impl.StudentServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
	  private static Logger log = LoggerFactory.getLogger(StudentController.class);
	    
	private StudentServiceImpl studentService;	
	
	@Autowired
	public StudentController(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	@ApiOperation(value = "getListOfStudent",
			      notes = "get all existed students in db ",
			      nickname = "getListOfStudent name",
			      produces="json")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Student>> getListOfStudent() {
		log.info("get list of student called");
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}
	
	@RequestMapping(value = "/{name}/{surname}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentByNameAndSurname(@PathVariable("name") String name,
			                        @PathVariable("surname") String surname) {
		return  ResponseEntity.ok(studentService.getStudentByNameAndSurname(name,surname));
	}


	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		 if(student.getName()==null) {
			 throw new MissingAtrributeException("The field name is missing");
		 }
		 
		studentService.addStudent(student);		
		return ResponseEntity.ok("student "+ student.getName()+ " "+ student.getSurname()+" has been added correctly");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateStudent( @PathVariable("id") Long id,@RequestBody Student student) {
		studentService.updateStudent(student, id);
		return ResponseEntity.ok("student "+ student.getName()+ " "+ student.getSurname()+" has been updated  correctly");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("student by id: "+ id+" has been deleted  correctly");
	}

}
