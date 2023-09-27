package com.seed.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_seq_gen")
	@SequenceGenerator(name = "add_seq_gen", sequenceName = "emp_address", allocationSize = 1, initialValue = 1)
	private Long id;
	private String city;
	private String pincode;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
	private Employee employee;

	public Address() {
	}

	public Address(String city, String pincode) {
		this.city = city;
		this.pincode = pincode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
