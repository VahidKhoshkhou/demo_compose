package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student {
    @Id  @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
//    @NotNull
//    @NotEmpty
	private String name;
//    @NotNull
//    @NotBlank()
	private String surname;
//    @Min(value = 0)
	private int studentAge;

	public Student() {

	}

	public Student(String name, String surname,int studentAge) {
		this.name = name;
		this.surname = surname;
		this.setStudentAge(studentAge);
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

}
