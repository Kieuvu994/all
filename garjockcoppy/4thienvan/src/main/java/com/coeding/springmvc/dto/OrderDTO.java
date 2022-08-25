package com.coeding.springmvc.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.coeding.springmvc.entity.Orderitemz;
import com.coeding.springmvc.entity.Shippingaddressz;
import com.coeding.springmvc.entity.Userz;

public class OrderDTO {
	private int id;
	private Userz userz;
	private Date createdAt;
	private Date deliveredAt;
	private byte isDelivered;
	private byte isPaid;
	private Date paidAt;
	private String paymentMethod;
	private BigDecimal shippingPrice;
	private BigDecimal taxPrice;
	private BigDecimal totalPrice;
	private Set<Shippingaddressz> shippingaddresszs = new HashSet<Shippingaddressz>(0);
	private Set<Orderitemz> orderitemzs = new HashSet<Orderitemz>(0);
	

	public OrderDTO(int id, Userz userz, Date createdAt, Date deliveredAt, byte isDelivered, byte isPaid, Date paidAt,
			String paymentMethod, BigDecimal shippingPrice, BigDecimal taxPrice, BigDecimal totalPrice) {
		this.id = id;
		this.userz = userz;
		this.createdAt = createdAt;
		this.deliveredAt = deliveredAt;
		this.isDelivered = isDelivered;
		this.isPaid = isPaid;
		this.paidAt = paidAt;
		this.paymentMethod = paymentMethod;
		this.shippingPrice = shippingPrice;
		this.taxPrice = taxPrice;
		this.totalPrice = totalPrice;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Userz getUserz() {
		return this.userz;
	}

	public void setUserz(Userz userz) {
		this.userz = userz;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDeliveredAt() {
		return this.deliveredAt;
	}

	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}

	public byte getIsDelivered() {
		return this.isDelivered;
	}

	public void setIsDelivered(byte isDelivered) {
		this.isDelivered = isDelivered;
	}

	public byte getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(byte isPaid) {
		this.isPaid = isPaid;
	}

	public Date getPaidAt() {
		return this.paidAt;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getShippingPrice() {
		return this.shippingPrice;
	}

	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public BigDecimal getTaxPrice() {
		return this.taxPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<Shippingaddressz> getShippingaddresszs() {
		return this.shippingaddresszs;
	}

	public void setShippingaddresszs(Set<Shippingaddressz> shippingaddresszs) {
		this.shippingaddresszs = shippingaddresszs;
	}

	public Set<Orderitemz> getOrderitemzs() {
		return this.orderitemzs;
	}

	public void setOrderitemzs(Set<Orderitemz> orderitemzs) {
		this.orderitemzs = orderitemzs;
	}

}
