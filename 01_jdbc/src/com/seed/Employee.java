package com.seed;

import java.util.List;
import java.util.Set;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private List<String> mobiles;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public List<String> getMobiles() {
		return mobiles;
	}
	
	public void setMobiles(List<String> mobiles) {
		this.mobiles = mobiles;
	}
	
	
}
