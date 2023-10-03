package com.seed.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ceo7")
@DiscriminatorValue(value = "ceo")
public class Ceo extends Manager {

	private Integer stake;

	public Ceo() {
		// TODO Auto-generated constructor stub
	}

	public Ceo(String name, Double salary, double bonus, Integer stake) {
		super(name, salary, bonus);
		this.stake = stake;
	}

	public Integer getStake() {
		return stake;
	}

	public void setStake(Integer stake) {
		this.stake = stake;
	}

}
