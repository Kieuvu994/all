package com.coeding.springmvc.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the orderitem database table.
 * 
 */

public class Orderitem {
	private int id;
	private String image;
	private String name;
	private BigDecimal price;
	private int qty;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Orderitem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}