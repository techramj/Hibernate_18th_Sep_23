package com.seed.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq_gen")
	@SequenceGenerator(name = "project_seq_gen", sequenceName = "project_seq", allocationSize = 1, initialValue = 1)
	private Integer projectId;

	private String name;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String name) {
		this.name = name;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
