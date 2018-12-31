package com.prism.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;

//import org.springframework.data.annotation.Id;
import javax.persistence.Id;

//import org.hibernate.annotations.Table;
import javax.persistence.Table;


@Entity
@Table(name = "project_type_mast",schema="prism")
public class ProjectTypeMast {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="project_type_desc")
	private String project_type_desc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject_type_desc() {
		return project_type_desc;
	}
	public void setProject_type_desc(String project_type_desc) {
		this.project_type_desc = project_type_desc;
	}
	public ProjectTypeMast() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
