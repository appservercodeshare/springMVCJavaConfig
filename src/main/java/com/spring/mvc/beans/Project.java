package com.spring.mvc.beans;

import java.util.Set;

public class Project {

	private String title;
	private String desc;
	private Role role;
	private String client;
	private Set<String> technologies;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Set<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Set<String> technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "Project [title=" + title + ", desc=" + desc + ", role=" + role 
				+ ", client=" + client + ", technologies=" + technologies + "]";
	}

}
