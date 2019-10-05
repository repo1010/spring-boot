package com.spring.angularspring.model;

import java.math.	BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private BigDecimal cost;
	


	public Product() {

	}

	public Product(String name, String description, BigDecimal cost) {
		super();
		// this.id = id;
		this.name = name;
		this.description = description;
		this.cost = cost;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	
	@Override
	public String toString() {
		return "Product [ name=" + name + ", description=" + description + ", cost=" + cost + "]";
	}

}
