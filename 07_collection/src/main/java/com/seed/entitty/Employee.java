package com.seed.entitty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "emp_01")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq_name")
	@SequenceGenerator(name="emp_seq_name", sequenceName = "emp_seq", initialValue = 1000, allocationSize = 1)
	private Integer id;
	
	@Column(name="first_name")
	private String name;
	
	private Double salary;
	
	@Embedded
	private Address address;
	
	@ElementCollection
	@JoinTable(name="emp_projects")
	private List<String> projects = new ArrayList<String>();
	
	
	@ElementCollection
	@JoinTable(name="emp_skill")
	private Set<String> skills = new HashSet<String>();
	
	public Employee() {
	}

	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public List<String> getProjects() {
		return projects;
	}
	
	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
	
	public void setProjects(String... projects) {
		for(String p:projects) {
			this.projects.add(p);
		}
	}
	
	public Set<String> getSkills() {
		return skills;
	}
	
	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}
	
	public void setSkills(String... skills) {
		
		for(String skill:skills) {
			this.skills.add(skill);
		}
	}

}
