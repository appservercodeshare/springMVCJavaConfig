package com.spring.mvc.utils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.validation.Errors;

import com.spring.mvc.beans.Address;
import com.spring.mvc.beans.Employee;
import com.spring.mvc.beans.Project;
import com.spring.mvc.beans.Role;
import com.spring.mvc.validations.annotations.ValidateAddressDetails;

public class Utils {

	public static boolean isEmptyOrNull(String value) {
		return value == null || value.trim().length() == 0;
	}
	
	public static boolean isEmptyOrNull(Object obj) {
		return obj == null; 
	}
	
	
	public static boolean isSetElementNullOrEmpty(Set<String> setElements) {
		
		for(String element : setElements) {
			if(!isEmptyOrNull(element)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isAllProjectFieldNullOrEmpty(Project project) {
		return isEmptyOrNull(project.getClient()) 
		&& isEmptyOrNull(project.getDesc())
		&& isEmptyOrNull(project.getTitle()) 
		&& isRoleEmptyOrNull(project.getRole()) 
		&& isSetElementNullOrEmpty(project.getTechnologies());
	}
	
	
	public static boolean isAnyProjectFieldNullOrEmpty(Project project) {
		return isEmptyOrNull(project.getClient()) 
				|| isEmptyOrNull(project.getDesc())
				|| isEmptyOrNull(project.getTitle()) 
				|| isRoleEmptyOrNull(project.getRole()) 
				|| isSetElementNullOrEmpty(project.getTechnologies());
		
		
			
	}
	
	public static Set<Project> getNonEmptyProjectSet(Set<Project> projects) {
		
		Set<Project> tempProjectSet = new HashSet<>();
		for(Project project : projects) {
			if(!isAllProjectFieldNullOrEmpty(project)) {
				tempProjectSet.add(project);
			}
		}
		
		return tempProjectSet;
	}
	
	
	public static boolean isSetElementNull(Set<?> setElements) {
		
		for(Object element : setElements) {
			if(isEmptyOrNull(element)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isRoleEmptyOrNull(Role role) {
		if(isEmptyOrNull(role)) {
			return true;
		} else if (isEmptyOrNull(role.getRoleName()) 
			&& isEmptyOrNull(role.getResponsiblities())) {
			return true;
		} 
		return false;
	}
	
	public static boolean validateAddress(Address address, ValidateAddressDetails validateAddressDetails) {
		
		String street = null;
		String city = null;
		String state = null;
		String pin = null;
		String country = null;
		
		if(!Utils.isEmptyOrNull(address)) {
			street = address.getStreet();
			city = address.getCity();
			state = address.getState();
			pin = address.getPin();
			country = address.getCountry();
		}
		
		int addressFields = validateAddressDetails.addressFields();
		
		if(addressFields < 4) {
			return false;
		}
		
		if(!Utils.isEmptyOrNull(pin)) {
			if(!pin.trim().matches("^\\d{6}$")) {
				return false;
			}
		}
		
		if(addressFields >= 4) {
			
		  if(!Utils.isEmptyOrNull(street) && !Utils.isEmptyOrNull(city)
		      && !Utils.isEmptyOrNull(state) && !Utils.isEmptyOrNull(pin)) {
			  boolean streetCity = street.equalsIgnoreCase(city);
			  boolean streetState = street.equalsIgnoreCase(state);
			  boolean streetPin = street.equalsIgnoreCase(pin);
			  boolean streetCountry = street.equalsIgnoreCase(country);
				 
			 if(streetCity || streetState || streetPin ||streetCountry) {
			   return false;
			 }
				 
			 boolean cityState = city.equalsIgnoreCase(state);
			 boolean cityPin = city.equalsIgnoreCase(pin);
			 boolean cityCountry = city.equalsIgnoreCase(country);
				 
			 if(cityState || cityPin || cityCountry) {
			   return false;
			 }
				 
			 boolean stateCountry = state.equalsIgnoreCase(country);
			 return(stateCountry)?false:true;	
		   }
		   return false;
		} else {
			return false; 
		}	
		
	}
	
	public static boolean validateProjects(Set<Project> projects) {
		
		Set<Project> tempProjectSet = getNonEmptyProjectSet(projects);
		if(tempProjectSet.size() < 1) {
			return true;
		}
		
		boolean[] boolArr = new boolean[tempProjectSet.size()];
		int index = 0;
		for(Project project : tempProjectSet) {
			boolArr[index++] = isAnyProjectFieldNullOrEmpty(project);
		} 
		
		for(boolean boolVal : boolArr) {
			if(boolVal == true) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void validateEmployee(Object command, Errors errors) {
		Employee employee = (Employee) command;
		
		Double salary = employee.getSalary();
		Double annualPkg = employee.getAnnualPkg();
		
		if(!Utils.isEmptyOrNull(salary) && !Utils.isEmptyOrNull(salary) 
			&& (salary * 12 ) > annualPkg) {
			errors.rejectValue("salary", "com.spring.mvc.employee.error.salary.mismatch.with.package");
			errors.rejectValue("annualPkg", "com.spring.mvc.employee.error.package.mismatch.with.salary");
		}
		
		Date joiningDate = employee.getJoiningDate();
		
		if(Utils.isEmptyOrNull(joiningDate)) { 
			errors.rejectValue("joiningDate", "com.spring.mvc.employee.error.joiningDate.required");
		} 
	}
}