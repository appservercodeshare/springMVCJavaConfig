package com.spring.mvc.validations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.spring.mvc.validations.annotations.EmptyOrDefaultInteger;

public class EmptyOrDefaultIntegerValidator implements ConstraintValidator<EmptyOrDefaultInteger, Integer>{
	
	@Override
	public void initialize(EmptyOrDefaultInteger emptyOrDefaultInteger) {
	}
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext ctx) {
		 
		if(value == null || value == 0) {
			return false;
		} else {
			return true;
		}
	}
	
}
