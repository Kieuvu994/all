package com.coeding.springmvc.entitys;

import java.io.Serializable;
import javax.persistence.*;


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
	private int id;

	private String name;

	public Categoryz() {
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

}