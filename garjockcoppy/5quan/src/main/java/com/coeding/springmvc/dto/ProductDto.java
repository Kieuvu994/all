package com.coeding.springmvc.dto;

import java.math.BigDecimal;

/**
 * 
 * @author Quan
 *
 */

public class ProductDto {
	private String name;
	private BigDecimal price;
	private String description;
	private String image;
	private int countInStock;
	
	
	public ProductDto(String name, BigDecimal price, String description, String image, int countInStock) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.countInStock = countInStock;
	}


	public ProductDto() {
		
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getCountInStock() {
		return countInStock;
	}


	public void setCountInStock(int countInStock) {
		this.countInStock = countInStock;
	}
	
	
}
