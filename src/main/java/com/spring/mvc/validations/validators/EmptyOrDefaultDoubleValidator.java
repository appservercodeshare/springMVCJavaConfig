package com.spring.mvc.validations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.spring.mvc.validations.annotations.EmptyOrDefaultDouble;

public class EmptyOrDefaultDoubleValidator implements ConstraintValidator<EmptyOrDefaultDouble, Double>{
	
	@Override
	public void initialize(EmptyOrDefaultDouble emptyOrDefaultDouble) {
	}
	
	@Override
	public boolean isValid(Double value, ConstraintValidatorContext ctx) {
		 
		if(value == null || value == 0) {
			return false;
		} else {
			return true;
		}
	}
	
}
