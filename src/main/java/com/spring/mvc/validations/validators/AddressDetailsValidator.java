package com.spring.mvc.validations.validators;

import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spring.mvc.beans.Address;
import com.spring.mvc.utils.Utils;
import com.spring.mvc.validations.annotations.ValidateAddressDetails;

public class AddressDetailsValidator implements ConstraintValidator<ValidateAddressDetails, Map<String, Address>>{
	
	private ValidateAddressDetails validateAddressDetails;

	@Override
	public void initialize(ValidateAddressDetails validateAddressDetails) {
		this.validateAddressDetails = validateAddressDetails;
	}
	
	@Override
	public boolean isValid(Map<String, Address> map, ConstraintValidatorContext ctx) {
		return Utils.validateAddress(map.get("present"), validateAddressDetails) 
			   && Utils.validateAddress(map.get("native"), validateAddressDetails);
	}
}
