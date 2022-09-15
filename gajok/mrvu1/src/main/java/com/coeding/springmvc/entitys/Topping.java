package com.coeding.springmvc.entitys;

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
	private int id;

	private String name;

	private int price;

	//bi-directional many-to-one association to Productz
	@OneToMany(mappedBy="topping")
	private List<Productz> productzs;

	public Topping() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Productz> getProductzs() {
		return this.productzs;
	}

	public void setProductzs(List<Productz> productzs) {
		this.productzs = productzs;
	}

	public Productz addProductz(Productz productz) {
		getProductzs().add(productz);
		productz.setTopping(this);

		return productz;
	}

	public Productz removeProductz(Productz productz) {
		getProductzs().remove(productz);
		productz.setTopping(null);

		return productz;
	}

}