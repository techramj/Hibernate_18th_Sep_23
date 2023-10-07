package com.seed.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="findByFirstName", query="from Employee e where e.firstName=:name"),
	@NamedQuery(name="findByLastName", query="from Employee e where e.lastName=:name"),
})
@Entity
@Table(name="emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq_gen")
	@SequenceGenerator(name = "emp_seq_gen", sequenceName = "emp_seq", allocationSize = 1, initialValue = 1000)
	private Integer id;

	@Column(name = "fname")
	private String firstName;

	@Column(name = "lname")
	private String lastName;

	private Double salary;

	private String job;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	public Employee(String firstName, String lastName, Double salary, String job) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.job = job;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
