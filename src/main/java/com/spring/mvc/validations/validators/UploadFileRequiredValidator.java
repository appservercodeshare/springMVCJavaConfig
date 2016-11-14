package com.spring.mvc.validations.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

import com.spring.mvc.validations.annotations.UploadFileRequired;

public class UploadFileRequiredValidator implements ConstraintValidator<UploadFileRequired, MultipartFile>{

	@Override
	public void initialize(UploadFileRequired uploadFileRequired) {
		
	}

	@Override
	public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext ConstraintValidatorContext) {
		
		if(multipartFile.getSize() == 0) {
			return false;
		}
		return true;
	}

	
}
