package com.coeding.springmvc.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
	private int id;
	private String brand;
	private int countInStock;
	private Date createdAt;
	private String description;
	private String name;
	private int numReview;
	private BigDecimal price;
	private int rating;
	private int categoryId;
	private int userId;
	
	private MultipartFile image;
	
	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public int getCountInStock() {
		return countInStock;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public int getNumReview() {
		return numReview;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getRating() {
		return rating;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public int getUserId() {
		return userId;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCountInStock(int countInStock) {
		this.countInStock = countInStock;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumReview(int numReview) {
		this.numReview = numReview;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
}