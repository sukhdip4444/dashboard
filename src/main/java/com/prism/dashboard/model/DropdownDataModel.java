package com.prism.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DropdownDataModel {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="title")
	private String title;
	private String proj_desc;
	private int proj_duration;
	private String proj_start_date;
	private String proj_end_date;
	private long proj_cost_total;
	public String getProj_desc() {
		return proj_desc;
	}
	public void setProj_desc(String proj_desc) {
		this.proj_desc = proj_desc;
	}
	public int getProj_duration() {
		return proj_duration;
	}
	public void setProj_duration(int proj_duration) {
		this.proj_duration = proj_duration;
	}
	public String getProj_start_date() {
		return proj_start_date;
	}
	public void setProj_start_date(String proj_start_date) {
		this.proj_start_date = proj_start_date;
	}
	public String getProj_end_date() {
		return proj_end_date;
	}
	public void setProj_end_date(String proj_end_date) {
		this.proj_end_date = proj_end_date;
	}
	public long getProj_cost_total() {
		return proj_cost_total;
	}
	public void setProj_cost_total(long proj_cost_total) {
		this.proj_cost_total = proj_cost_total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public DropdownDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
