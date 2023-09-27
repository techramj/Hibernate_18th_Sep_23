package com.seed.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public Employee() {
		
	}

	public Employee(String name, Double salary, Address address) {
		super();
		this.name = name;
		this.salary = salary;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
