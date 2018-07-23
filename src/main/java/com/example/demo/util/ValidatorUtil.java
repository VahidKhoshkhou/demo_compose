package com.example.demo.util;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorUtil {
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	 private static Validator validator = factory.getValidator();
	 
	 public static <T> Set<ConstraintViolation<T>> getValidattionError(T instance) {
		return validator.validate(instance);
	}
	 
	public static <T> Set<String>  validateAndGetErrors(T instance){
		Set<ConstraintViolation<T>> violations=getValidattionError(instance);
		Set<String> errors=new HashSet<>();
		violations.stream().forEach(violation->{
			errors.add(violation.getMessage());
		});
		return errors;
	}
	
}
