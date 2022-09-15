package com.coeding.springmvc.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the topping database table.
 * 
 */

public class Topping {
	private int _id;
	private String name;
	private BigDecimal price;
	
	public Topping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}