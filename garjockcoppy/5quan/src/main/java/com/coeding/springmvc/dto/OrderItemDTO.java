package com.coeding.springmvc.dto;

import java.math.BigDecimal;

/**
 * 
 * @author Quan
 *
 */

public class OrderItemDTO {
	private int id;
	private String name;
	private BigDecimal price;
	private int qty;
	private String image;
	private int orderId;
	private int productId;
	private int sizeId;
	private int toppingId;
	
	public OrderItemDTO(int id, String name, BigDecimal price, int qty, String image, int orderId, int productId,
			int sizeId, int toppingId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.image = image;
		this.orderId = orderId;
		this.productId = productId;
		this.sizeId = sizeId;
		this.toppingId = toppingId;
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getToppingId() {
		return toppingId;
	}
	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}
	
	
	
	
}
