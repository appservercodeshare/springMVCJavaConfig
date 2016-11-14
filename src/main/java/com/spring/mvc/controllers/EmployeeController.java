package com.spring.mvc.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.beans.Employee;
import com.spring.mvc.beans.Project;
import com.spring.mvc.beans.Role;

@Controller
@SessionAttributes({"employee"})
public class EmployeeController {

	@Autowired
	@Qualifier("employeeValidator")
	private Validator employeeValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(employeeValidator);
	}
	
	@GetMapping("/showEmployeeAdd")
	public String employeeAdd(@ModelAttribute("employee") Employee employee) {
		return "displayAddEmployee";
	}
	
	@RequestMapping(value = "/addEmployee", method={RequestMethod.POST})
	public ModelAndView addEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult errors) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", employee);
		
		if(errors.hasErrors()) {
			modelAndView.setViewName("displayAddEmployee");
		} else {
			modelAndView.setViewName("employeeAdded");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/viewAddEmployee", method={RequestMethod.GET})
	public String viewAddEmployee(@ModelAttribute("employee") Employee employee) {
		return "employeeAdded";
	}
	
	@RequestMapping(value = "/addEmployeePrevious", method = {RequestMethod.POST})
	public ModelAndView addEmployeePrevious(@ModelAttribute("employee") Employee employee) {
		ModelAndView modelAndView = new ModelAndView("displayAddEmployee", "employee", employee);
		return modelAndView;
	}
	
	@RequestMapping(value = "/addEmployeeNext", method = {RequestMethod.POST})
	public ModelAndView addEmployeeNext(@ModelAttribute("employee") Employee employee) {
		ModelAndView modelAndView = new ModelAndView("displayAddEmployeeNext", "employee", employee);
		return modelAndView;
	}
	
	
	@ModelAttribute("employee")
	public Employee populateEmployee() {
		
		Employee employee = new Employee();
		Set<Project> projectSet = new HashSet<Project>();
		Project project = new Project();
		project.setRole(new Role());
		projectSet.add(project);
		
		project = new Project();
		project.setRole(new Role());
		projectSet.add(project);
		
		project = new Project();
		project.setRole(new Role());
		projectSet.add(project);
		
		employee.setProjects(projectSet);
		return employee;
	}
	
	@ModelAttribute("skillsSet")
	public Map<String, String> skillsSet() {
		 Map<String, String> skillsSet = new LinkedHashMap<String, String>();
		 skillsSet.put("j2ee", "J2EE");
		 skillsSet.put("spring", "Spring");
		 skillsSet.put("hibernate", "Hibernate");
		 skillsSet.put("rest", "REST");
		 skillsSet.put("jdbc", "JDBC");
		 skillsSet.put("jpa", "JPA");
		 skillsSet.put("jta", "JTA");
		 skillsSet.put("struts2", "Struts2");
		 skillsSet.put("jsf", "JSF");
		 skillsSet.put("jenkins", "Jenkins");
		 skillsSet.put("oracle", "oracle");
		 skillsSet.put("mysql", "MySql");
		 return skillsSet;
	}
	
	@ModelAttribute("experenceList")
	public List<Integer> experienceList() {
		List<Integer> experienceList = new ArrayList<Integer>();
		for(int i=0; i<50; i++) {
			experienceList.add(i);	
		}
		return experienceList;
	}
	
	
	@ModelAttribute("genders")
	public Map<String, String> genders() {
		Map<String, String> genders = new LinkedHashMap<String, String>();
		genders.put("male", "Male");
		genders.put("female", "Female");
		return genders;
	}
	
	@ModelAttribute("contactTypes")
	public Map<String, String> contactTypes() {
		Map<String, String> contactTypes = new LinkedHashMap<String, String>();
		contactTypes.put("phone", "Phone");
		contactTypes.put("mobile", "Mobile");
		contactTypes.put("fax", "FAX");
		contactTypes.put("email", "Email");
		contactTypes.put("pager", "Pager");
		return contactTypes;
	}
	
	@ModelAttribute("technologies")
	public Map<String, String> technologies() {
		 Map<String, String> skillsSet = new LinkedHashMap<String, String>();
		 skillsSet.put("j2ee", "J2EE");
		 skillsSet.put("spring", "Spring");
		 skillsSet.put("hibernate", "Hibernate");
		 skillsSet.put("rest", "REST");
		 skillsSet.put("jdbc", "JDBC");
		 skillsSet.put("jpa", "JPA");
		 skillsSet.put("jta", "JTA");
		 skillsSet.put("struts2", "Struts2");
		 skillsSet.put("jsf", "JSF");
		 skillsSet.put("jenkins", "Jenkins");
		 skillsSet.put("oracle", "oracle");
		 skillsSet.put("mysql", "MySql");
		 return skillsSet;
	}
	
	@ModelAttribute("projectList")
	public Set<Project> projectList() {
		Set<Project> projectList = new HashSet<Project>();
		projectList.add(new Project());
		projectList.add(new Project());
		projectList.add(new Project());
		 return projectList;
	}
	
}