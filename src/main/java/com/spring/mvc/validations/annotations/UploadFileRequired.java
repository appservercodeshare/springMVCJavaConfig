package com.spring.mvc.validations.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.mvc.validations.validators.UploadFileRequiredValidator;

@Documented
@Constraint(validatedBy = UploadFileRequiredValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UploadFileRequired {
	String message() default "{UploadFileRequired}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
