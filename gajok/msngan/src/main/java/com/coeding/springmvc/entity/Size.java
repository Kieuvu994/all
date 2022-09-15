package com.coeding.springmvc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the size database table.
 * 
 */

public class Size  {
	private int id;
	private BigDecimal price;
	public String name;
	public Size(int id, BigDecimal price, String size) {
		super();
		this.id = id;
		this.price = price;
		this.name = size;
	}
	public Size() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSize() {
		return name;
	}
	public void setSize(String size) {
		this.name = size;
	}
	
}