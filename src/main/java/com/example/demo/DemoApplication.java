package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

    private static Logger log = LoggerFactory.getLogger(DemoApplication.class);
    
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	public static List<Student> initMethod() {
		log.info("Application started ");
	    List<Student> books = Arrays.asList(new Student("aaa","bbb",25),
	    		new Student("aaa","bbb",17),
	    		new Student("aaa","bbb",23)
	       );
	    return books;
	  }

	@Override
	public void run(String... arg0) throws Exception {		
		 initMethod().stream().forEach(s -> studentRepository.save(s));		 
	}
	
}
