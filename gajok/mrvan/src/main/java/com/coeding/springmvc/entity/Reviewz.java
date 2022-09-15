package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reviewz database table.
 * 
 */
@Entity
@NamedQuery(name="Reviewz.findAll", query="SELECT r FROM Reviewz r")
public class Reviewz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="_id")
	private int id;

	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	private String name;

	private int rating;

	//bi-directional many-to-one association to Productz
	@ManyToOne
	@JoinColumn(name="product_id")
	private Productz productz;

	//bi-directional many-to-one association to Userz
	@ManyToOne
	@JoinColumn(name="user_id")
	private Userz userz;

	public Reviewz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Productz getProductz() {
		return this.productz;
	}

	public void setProductz(Productz productz) {
		this.productz = productz;
	}

	public Userz getUserz() {
		return this.userz;
	}

	public void setUserz(Userz userz) {
		this.userz = userz;
	}

}