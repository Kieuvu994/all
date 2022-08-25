package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sizez database table.
 * 
 */
@Entity
@NamedQuery(name="Sizez.findAll", query="SELECT s FROM Sizez s")
public class Sizez implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="_id")
	private int id;

	private String name;

	private int price;

	//bi-directional many-to-one association to Productz
	@OneToMany(mappedBy="sizez")
	private List<Productz> productzs;

	public Sizez() {
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
		productz.setSizez(this);

		return productz;
	}

	public Productz removeProductz(Productz productz) {
		getProductzs().remove(productz);
		productz.setSizez(null);

		return productz;
	}

}