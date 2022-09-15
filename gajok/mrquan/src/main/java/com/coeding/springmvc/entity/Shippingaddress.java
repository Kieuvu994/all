package com.coeding.springmvc.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the shippingaddress database table.
 * 
 */

public class Shippingaddress  {
	private int id;
	private String address;
	private String city;
	private String country;
	private String postalCode;
	private BigDecimal shippingPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public Shippingaddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}