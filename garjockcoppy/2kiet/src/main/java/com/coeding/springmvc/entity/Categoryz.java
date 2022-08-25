package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoryz database table.
 * 
 */
@Entity
@NamedQuery(name="Categoryz.findAll", query="SELECT c FROM Categoryz c")
public class Categoryz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;

	private String name;

	//bi-directional many-to-one association to Productz
	@OneToMany(mappedBy="category_id")
	private List<Productz> productzs;

	public Categoryz() {
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

	public List<Productz> getProductzs() {
		return this.productzs;
	}

	public void setProductzs(List<Productz> productzs) {
		this.productzs = productzs;
	}

	public Productz addProductz(Productz productz) {
		getProductzs().add(productz);
		productz.setCategoryz(this);

		return productz;
	}

	public Productz removeProductz(Productz productz) {
		getProductzs().remove(productz);
		productz.setCategoryz(null);

		return productz;
	}

}