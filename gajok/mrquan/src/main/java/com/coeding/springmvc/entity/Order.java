package com.coeding.springmvc.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */

public class Order {

	private int id;
	private Date createdAt;
	private Date deliveredAt;
	private byte isDelivered;
	private byte isPaid;
	private Date paidAt;
	private BigDecimal paymentMethod;
	private BigDecimal shippingPrice;
	private BigDecimal taxPrice;
	private BigDecimal totalPrice;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getDeliveredAt() {
		return deliveredAt;
	}
	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
	public byte getIsDelivered() {
		return isDelivered;
	}
	public void setIsDelivered(byte isDelivered) {
		this.isDelivered = isDelivered;
	}
	public byte getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(byte isPaid) {
		this.isPaid = isPaid;
	}
	public Date getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}
	public BigDecimal getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(BigDecimal paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public BigDecimal getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Order() {
		super();
		
	}

	
	
}