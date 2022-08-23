package com.coeding.springmvc.entitys;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the productz database table.
 * 
 */
@Entity
@NamedQuery(name="Productz.findAll", query="SELECT p FROM Productz p")
public class Productz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="_id")
	private int id;

	private String brand;

	private String category;

	private int countInStock;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Lob
	private String description;

	private String image;

	private String name;

	private int numReview;

	private BigDecimal price;

	private int rating;

	//bi-directional many-to-one association to Orderitemz
	@OneToMany(mappedBy="productz")
	private List<Orderitemz> orderitemzs;

	//bi-directional many-to-one association to Userz
	@ManyToOne
	@JoinColumn(name="user_id")
	private Userz userz;

	//bi-directional many-to-one association to Topping
	@ManyToOne
	@JoinColumn(name="topping_id")
	private Topping topping;

	//bi-directional many-to-one association to Sizez
	@ManyToOne
	@JoinColumn(name="size_id")
	private Sizez sizez;

	//bi-directional many-to-one association to Reviewz
	@OneToMany(mappedBy="productz")
	private List<Reviewz> reviewzs;

	public Productz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCountInStock() {
		return this.countInStock;
	}

	public void setCountInStock(int countInStock) {
		this.countInStock = countInStock;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public int getNumReview() {
		return this.numReview;
	}

	public void setNumReview(int numReview) {
		this.numReview = numReview;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<Orderitemz> getOrderitemzs() {
		return this.orderitemzs;
	}

	public void setOrderitemzs(List<Orderitemz> orderitemzs) {
		this.orderitemzs = orderitemzs;
	}

	public Orderitemz addOrderitemz(Orderitemz orderitemz) {
		getOrderitemzs().add(orderitemz);
		orderitemz.setProductz(this);

		return orderitemz;
	}

	public Orderitemz removeOrderitemz(Orderitemz orderitemz) {
		getOrderitemzs().remove(orderitemz);
		orderitemz.setProductz(null);

		return orderitemz;
	}

	public Userz getUserz() {
		return this.userz;
	}

	public void setUserz(Userz userz) {
		this.userz = userz;
	}

	public Topping getTopping() {
		return this.topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	public Sizez getSizez() {
		return this.sizez;
	}

	public void setSizez(Sizez sizez) {
		this.sizez = sizez;
	}

	public List<Reviewz> getReviewzs() {
		return this.reviewzs;
	}

	public void setReviewzs(List<Reviewz> reviewzs) {
		this.reviewzs = reviewzs;
	}

	public Reviewz addReviewz(Reviewz reviewz) {
		getReviewzs().add(reviewz);
		reviewz.setProductz(this);

		return reviewz;
	}

	public Reviewz removeReviewz(Reviewz reviewz) {
		getReviewzs().remove(reviewz);
		reviewz.setProductz(null);

		return reviewz;
	}

}