package com.prism.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

public class ProjectApproachMastModel {
	@Entity
	public class PrismApproachMast {
		
		@Id
		@Column(name="id")
		private int id;
		@Column(name="approach_desc")
		private String approach_desc;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getApproachDesc() {
			return approach_desc;
		}
		public void setApproachDesc(String approachDesc) {
			this.approach_desc = approachDesc;
		}
		public PrismApproachMast() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
}
