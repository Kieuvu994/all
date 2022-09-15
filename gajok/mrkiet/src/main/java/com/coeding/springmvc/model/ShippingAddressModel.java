package com.coeding.springmvc.model;

import java.math.BigDecimal;

public class ShippingAddressModel {
	private int _id;

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	private String address;

	private String city;

	private String country;

	private String postalCode;

	private BigDecimal shippingPrice;

	private Integer orderID;

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

}
