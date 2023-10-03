package com.seed.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="manager2")
@PrimaryKeyJoinColumn(name="id")
public class Manager extends Employee {

	private double bonus;

	public Manager() {

	}

	public Manager(String name, Double salary, double bonus) {
		super(name, salary);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
