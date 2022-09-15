package com.coeding.springmvc.dto;

import java.math.BigDecimal;

import com.coeding.springmvc.entity.Orderz;

public class ShippingaddressDTO {
	
	private int id;
	private String address;
	private String city;
	private String country;
	private String postalCode;
	private BigDecimal shippingPrice;
	private Orderz orderz;
	
	public ShippingaddressDTO() {
		
	}
	
	public ShippingaddressDTO(int id, String address, String city, String country, String postalCode, BigDecimal shippingPrice, Orderz orderz) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.shippingPrice = shippingPrice;
		this.orderz = orderz;
	}
	
	public ShippingaddressDTO(String address, String city, String country, String postalCode, BigDecimal shippingPrice, Orderz orderz) {
		super();
		this.address = address;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.shippingPrice = shippingPrice;
		this.orderz = orderz;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public BigDecimal getShippingPrice() {
		return this.shippingPrice;
	}

	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public Orderz getOrderz() {
		return this.orderz;
	}

	public void setOrderz(Orderz orderz) {
		this.orderz = orderz;
	}

}
