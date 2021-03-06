package com.spring.mvc.validations.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.mvc.validations.validators.ContactDetailsValidator;

@Documented
@Constraint(validatedBy = ContactDetailsValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateContactDetails {
	String message() default "{ValidateContactDetails}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String[] allowedContactType() default {"phone", "mobile"};
}