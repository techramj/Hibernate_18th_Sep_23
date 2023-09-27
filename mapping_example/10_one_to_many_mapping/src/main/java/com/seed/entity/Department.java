package com.seed.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {

	@Id
	@Column(name = "did")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq_gen")
	@SequenceGenerator(name = "dept_seq_gen", sequenceName = "dept_seq", allocationSize = 10, initialValue = 10)
	private Integer id;

	@Column(name = "dept_name")
	private String name;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String name) {
		super();
		this.name = name;
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

}
