package com.prism.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CostWiseProjectSubmittedModel {
	@Id
	@Column(name="state_name")
	private String state_name;
	@Column(name="sum")
	private long sum;
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		this.sum = sum;
	}
	
}
