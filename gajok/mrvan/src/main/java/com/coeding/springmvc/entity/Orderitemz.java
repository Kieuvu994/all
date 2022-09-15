package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the orderitemz database table.
 * 
 */
@Entity
@NamedQuery(name="Orderitemz.findAll", query="SELECT o FROM Orderitemz o")
public class Orderitemz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="_id")
	private int id;

	private String image;

	private String name;

	private BigDecimal price;

	private int qty;

	//bi-directional many-to-one association to Orderz
	@ManyToOne
	@JoinColumn(name="order_id")
	private Orderz orderz;
	
	//bi-directional many-to-one association to Orderz
	@ManyToOne
	@JoinColumn(name="size_id")
	private Sizez sizez;

	//bi-directional many-to-one association to Orderz
	@ManyToOne
	@JoinColumn(name="topping_id")
	private Topping topping;
	
	//bi-directional many-to-one association to Productz
	@ManyToOne
	@JoinColumn(name="product_id")
	private Productz productz;

	public Orderitemz() {
	}
	
	public Orderitemz(int id, Orderz orderz, Productz productz, Sizez sizez, Topping topping, String name, BigDecimal price, int qty, String image ) {
		this.id = id;
		this.orderz = orderz;
		this.productz = productz;
		this.sizez = sizez;
		this.topping = topping;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.image =image;
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Sizez getSizez() {
		return this.sizez;
	}

	public void setSizez(Sizez sizez) {
		this.sizez = sizez;
	}

	public Topping getTopping() {
		return this.topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Orderz getOrderz() {
		return this.orderz;
	}

	public void setOrderz(Orderz orderz) {
		this.orderz = orderz;
	}

	public Productz getProductz() {
		return this.productz;
	}

	public void setProductz(Productz productz) {
		this.productz = productz;
	}

}