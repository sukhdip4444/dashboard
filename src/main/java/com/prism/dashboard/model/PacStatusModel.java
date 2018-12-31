package com.prism.dashboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PacStatusModel {
	@Id
	private String status_desc;
	private int count;
	public String getStatus_desc() {
		return status_desc;
	}
	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
