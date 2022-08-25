package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private String brand;
	private int countInStock;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Lob
	private String description;
	private String image;
	private String name;
	private int numReview;
	
	private int quantity = 1; 
	private BigDecimal price; 	   //unit price
	private BigDecimal totalPrice; //total price
	
	private int rating;
	
	
	private double discount = 0.0;
	

	//bi-directional many-to-one association to Orderitemz
	@OneToMany(mappedBy="productz")
	private List<Orderitemz> orderitemzs;

	//bi-directional many-to-one association to Userz
	@ManyToOne
	@JoinColumn(name="user_id")
	private Userz userz;

	//bi-directional many-to-one association to Categoryz
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id", referencedColumnName = "_id")
	private Categoryz category_id;
	
	//bi-directional many-to-one association to Reviewz
	@OneToMany(mappedBy="productz")
	private List<Reviewz> reviewzs;

	public Productz() {
	}

	public int getId() {
		return this._id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public Categoryz getCategoryz() {
		return this.category_id;
	}

	public void setCategoryz(Categoryz categoryz) {
		this.category_id = categoryz;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}