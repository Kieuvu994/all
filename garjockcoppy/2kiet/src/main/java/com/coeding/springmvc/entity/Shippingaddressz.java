package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the shippingaddressz database table.
 * 
 */
@Entity
@NamedQuery(name="Shippingaddressz.findAll", query="SELECT s FROM Shippingaddressz s")
public class Shippingaddressz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;

	private String address;

	private String city;

	private String country;

	private String postalCode;

	private BigDecimal shippingPrice;

	//bi-directional many-to-one association to Orderz
	@ManyToOne
	@JoinColumn(name="order_id")
	private Orderz orderz;

	public Shippingaddressz() {
	}

	public int getId() {
		return this._id;
	}

	public void setId(int id) {
		this._id = id;
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