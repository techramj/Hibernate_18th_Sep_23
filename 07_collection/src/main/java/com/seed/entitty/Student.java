package com.seed.entitty;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="one" )
	@SequenceGenerator(name = "one" , sequenceName = "stud_seq", allocationSize = 1)
	private Integer rollNo;

	@Column(name = "student_name")
	private String name;

	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name="pincode", column = @Column(name="mailing_code")),
			@AttributeOverride(name="landmark", column = @Column(name="land_mark"))
	})
	private Address address;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

}
