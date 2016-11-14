package com.spring.mvc.validations.validators;

import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.spring.mvc.beans.Project;
import com.spring.mvc.validations.annotations.ProjectValidation;
import static com.spring.mvc.utils.Utils.validateProjects;

public class ProjectValidator implements ConstraintValidator<ProjectValidation, Set<Project>>{
	
	@Override
	public void initialize(ProjectValidation projectValidation) {
	}

	@Override
	public boolean isValid(Set<Project> projects, ConstraintValidatorContext constraintValidatorContext) {
		return validateProjects(projects);
	}

}
