package com.spring.mvc.validations.validators;

import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.spring.mvc.validations.annotations.ValidateContactDetails;

public class ContactDetailsValidator implements ConstraintValidator<ValidateContactDetails, Map<String, String>>{
	
	private ValidateContactDetails validateContactDetails;

	@Override
	public void initialize(ValidateContactDetails validateContactDetails) {
		this.validateContactDetails = validateContactDetails;
	}
	
	@Override
	public boolean isValid(Map<String, String> map, ConstraintValidatorContext ctx) {
		 
		String contactType = map.get("contactType");
		String[] contactTypes = validateContactDetails.allowedContactType();
		
		if(contactType == null || contactType.trim().length() == 0) {
			return true;
		}
		
		for(String tempContactType : contactTypes) {
			if(tempContactType.equalsIgnoreCase(contactType)) {
				return true;
			}
		}
		
		return false;
	}
	
}
