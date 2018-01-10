package com.luv2code.springdemo.mvc.validation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.luv2code.springdemo.mvc.validation.CourseCode;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	private String coursePrefix;

	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null ? value.startsWith(coursePrefix) : false;
	}

}
