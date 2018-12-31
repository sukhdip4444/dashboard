package com.prism.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StateWisePojectsModel {
	@Id
	@Column(name="state_name")
	private String state_name;
	@Column(name="count")
	private int count;
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public long getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
