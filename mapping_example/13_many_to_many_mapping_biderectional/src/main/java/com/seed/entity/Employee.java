package com.seed.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq_gen")
	@SequenceGenerator(name = "emp_seq_gen", sequenceName = "emp_seq", allocationSize = 1, initialValue = 1000)
	private Integer id;
	private String name;
	private Double salary;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "emp_project", joinColumns = { @JoinColumn(name = "eid") }, inverseJoinColumns = {
			@JoinColumn(name = "project_id") })
	private List<Project> projects = new ArrayList<Project>();

	public Employee() {

	}

	public Employee(String name, Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void addProjects(Project... projects) {
		this.projects.addAll(Arrays.asList(projects));
	}

}
