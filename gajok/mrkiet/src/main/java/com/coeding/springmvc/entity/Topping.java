package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the topping database table.
 * 
 */
@Entity
@NamedQuery(name="Topping.findAll", query="SELECT t FROM Topping t")
public class Topping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;

	private String name;

	private int price;

	//bi-directional many-to-one association to Orderitemz
	@OneToMany(mappedBy="topping")
	private List<Orderitemz> orderitemzs;

	public Topping() {
	}

	public int getId() {
		return this._id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Orderitemz> getOrderitemzs() {
		return this.orderitemzs;
	}

	public void setOrderitemzs(List<Orderitemz> orderitemzs) {
		this.orderitemzs = orderitemzs;
	}

	public Orderitemz addOrderitemz(Orderitemz orderitemz) {
		getOrderitemzs().add(orderitemz);
		orderitemz.setTopping(this);

		return orderitemz;
	}

	public Orderitemz removeOrderitemz(Orderitemz orderitemz) {
		getOrderitemzs().remove(orderitemz);
		orderitemz.setTopping(null);

		return orderitemz;
	}

}