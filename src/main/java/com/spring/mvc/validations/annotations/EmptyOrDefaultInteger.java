package com.spring.mvc.validations.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.mvc.validations.validators.EmptyOrDefaultIntegerValidator;

@Documented
@Constraint(validatedBy = EmptyOrDefaultIntegerValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmptyOrDefaultInteger {
	String message() default "{EmptyOrDefaultInteger}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
