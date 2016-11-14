package com.spring.mvc.validations.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.mvc.beans.Employee;
import com.spring.mvc.utils.Utils;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object command, Errors errors) {
		Utils.validateEmployee(command, errors);
	}
}