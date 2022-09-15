package com.coeding.springmvc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.coeding.springmvc.entity.Shippingaddressz;
import com.coeding.springmvc.entity.Userz;

public class OrderModel {
	private int _id;
	
	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	private Date createdAt;

	private Date deliveredAt;

	private byte isDelivered;

	private byte isPaid;

	private Date paidAt;

	private String paymentMethod;
	
	private BigDecimal shippingPrice;

	private BigDecimal taxPrice;

	private BigDecimal totalPrice;
	
	private List<OrderItemModel> orderitem = new ArrayList<OrderItemModel>();

	private Userz user;

	private List<Shippingaddressz> shippingaddress = new ArrayList<Shippingaddressz>() ;

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getDeliveredAt() {
		return deliveredAt;
	}

	public byte getIsDelivered() {
		return isDelivered;
	}

	public byte getIsPaid() {
		return isPaid;
	}

	public Date getPaidAt() {
		return paidAt;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}

	public void setIsDelivered(byte isDelivered) {
		this.isDelivered = isDelivered;
	}

	public void setIsPaid(byte isPaid) {
		this.isPaid = isPaid;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}

	public BigDecimal getTaxPrice() {
		return taxPrice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}


	public List<Shippingaddressz> getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderItemModel> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<OrderItemModel> orderitem) {
		this.orderitem = orderitem;
	}

	public Userz getUser() {
		return user;
	}

	public void setUser(Userz user) {
		this.user = user;
	}

	public void setShippingaddress(List<Shippingaddressz> shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

}
