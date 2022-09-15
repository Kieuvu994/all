package com.coeding.springmvc.model;

import java.math.BigDecimal;

public class OrderItemModel {
	private int _id;

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	private String image;

	private String name;

	private BigDecimal price;

	private int qty;

	private Integer orderID;

	private Integer productID;

	private Integer sizeID;

	private Integer toppingID;

	public String getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public Integer getProductID() {
		return productID;
	}

	public Integer getSizeID() {
		return sizeID;
	}

	public Integer getToppingID() {
		return toppingID;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public void setSizeID(Integer sizeID) {
		this.sizeID = sizeID;
	}

	public void setToppingID(Integer toppingID) {
		this.toppingID = toppingID;
	}

}
