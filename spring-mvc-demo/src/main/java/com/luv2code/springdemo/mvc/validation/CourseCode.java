package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import com.luv2code.springdemo.mvc.validation.impl.CourseCodeConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	public String value() default "LUV";
	public String message() default "Must start with 'LUV'";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}
