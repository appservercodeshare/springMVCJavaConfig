package com.spring.mvc.beans;

public class Role {

	private String roleName;
	private String responsiblities;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getResponsiblities() {
		return responsiblities;
	}

	public void setResponsiblities(String responsiblities) {
		this.responsiblities = responsiblities;
	}

	@Override
	public String toString() {
		return "Role [roleName=" + roleName + 
				", responsiblities=" + responsiblities + "]";
	}
	
	

}
