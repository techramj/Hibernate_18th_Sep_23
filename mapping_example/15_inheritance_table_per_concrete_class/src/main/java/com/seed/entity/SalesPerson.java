package com.seed.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sales_person1")
public class SalesPerson extends Employee {

	@Column(name = "sales")
	private double salesMade;

	@Column(name = "comm")
	private double commission;

	public SalesPerson() {
		// TODO Auto-generated constructor stub
	}

	public SalesPerson(String name, Double salary, double salesMade, double comm) {
		super(name, salary);
		this.salesMade = salesMade;
		this.commission = comm;
	}

	public double getSalesMade() {
		return salesMade;
	}

	public void setSalesMade(double salesMade) {
		this.salesMade = salesMade;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

}
