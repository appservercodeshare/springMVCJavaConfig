package com.spring.mvc.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.spring.mvc.validations.annotations.EmptyOrDefaultDouble;
import com.spring.mvc.validations.annotations.EmptyOrDefaultInteger;
import com.spring.mvc.validations.annotations.ProjectValidation;
import com.spring.mvc.validations.annotations.UploadFileRequired;
import com.spring.mvc.validations.annotations.ValidateAddressDetails;
import com.spring.mvc.validations.annotations.ValidateContactDetails;

public class Employee {

	@NotBlank(message = "{com.spring.mvc.employee.error.firstname.required}")
	private String firstName;

	@NotBlank(message = "{com.spring.mvc.employee.error.lastname.required}")
	private String lastName;

	@NotBlank(message = "{com.spring.mvc.employee.error.gender.required}")
	private String gender;

	@Past(message = "{com.spring.mvc.employee.error.joiningDate.should.be.in.past}")
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date joiningDate;

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date releaseDate;

	@NotEmpty(message = "{com.spring.mvc.employee.error.skills.required}")
	private List<String> skills;

	@EmptyOrDefaultInteger(message = "{com.spring.mvc.employee.error.experience.required}")
	private Integer experience;

	@EmptyOrDefaultDouble(message = "{com.spring.mvc.employee.error.salary.required}")
	private Double salary;

	@EmptyOrDefaultDouble(message = "{com.spring.mvc.employee.error.package.required}")
	private Double annualPkg;

	@NotEmpty(message = "{com.spring.mvc.employee.error.contact.details.required}")
	@ValidateContactDetails(message = "{com.spring.mvc.employee.error.contacttype.invalid}", allowedContactType = {
			"phone", "mobile", "email", "fax" })
	private Map<String, String> contacts;

	@NotEmpty(message = "{com.spring.mvc.employee.error.address.details.required}")
	@ValidateAddressDetails(message = "{com.spring.mvc.employee.error.address.details.required}", addressFields = 4)
	private Map<String, Address> addresses;

	@NotEmpty(message = "com.spring.mvc.employee.error.project.required")
	@ProjectValidation(message = "{com.spring.mvc.employee.error.project.all.fields.required}")
	private Set<Project> projects;

	@UploadFileRequired(message = "{com.spring.mvc.employee.error.profile.required}")
	private MultipartFile profile;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String gender, Date joiningDate, Date releaseDate,
			List<String> skills, Integer experience, Double salary, Double annualPkg, Map<String, String> contacts,
			Map<String, Address> addresses, Set<Project> projects, MultipartFile profile) {

		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.joiningDate = joiningDate;
		this.releaseDate = releaseDate;
		this.skills = skills;
		this.experience = experience;
		this.salary = salary;
		this.annualPkg = annualPkg;
		this.contacts = contacts;
		this.addresses = addresses;
		this.projects = projects;
		this.profile = profile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Map<String, String> getContacts() {
		return contacts;
	}

	public void setContacts(Map<String, String> contacts) {
		this.contacts = contacts;
	}

	public Map<String, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<String, Address> addresses) {
		this.addresses = addresses;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getAnnualPkg() {
		return annualPkg;
	}

	public void setAnnualPkg(Double annualPkg) {
		this.annualPkg = annualPkg;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public MultipartFile getProfile() {
		return profile;
	}

	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", joiningDate="
				+ joiningDate + ", releaseDate=" + releaseDate + ", skills=" + skills 
				+ ", experience=" + experience + ", salary=" + salary + ", annualPkg=" 
				+ annualPkg + ", contacts=" + contacts + ", addresses=" + addresses 
				+ ", projects=" + projects + ", profile=" + profile + "]";
	}

}
