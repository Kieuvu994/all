package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orderz database table.
 * 
 */
@Entity
@NamedQuery(name="Orderz.findAll", query="SELECT o FROM Orderz o")
public class Orderz implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="_id")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveredAt;

	private byte isDelivered;

	private byte isPaid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date paidAt;

	private String paymentMethod;

	private BigDecimal shippingPrice;

	private BigDecimal taxPrice;

	private BigDecimal totalPrice;

	//bi-directional many-to-one association to Orderitemz
	@OneToMany(mappedBy="orderz")
	private List<Orderitemz> orderitemzs;

	//bi-directional many-to-one association to Userz
	@ManyToOne
	@JoinColumn(name="user_id")
	private Userz userz;

	//bi-directional many-to-one association to Shippingaddressz
	@OneToMany(mappedBy="orderz")
	private List<Shippingaddressz> shippingaddresszs;

	public Orderz() {
	}
	
	public Orderz(int id, Userz userz, Date createdAt, Date deliveredAt, byte isDelivered, byte isPaid, Date paidAt,
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

	public List<Orderitemz> getOrderitemzs() {
		return this.orderitemzs;
	}

	public void setOrderitemzs(List<Orderitemz> orderitemzs) {
		this.orderitemzs = orderitemzs;
	}

	public Orderitemz addOrderitemz(Orderitemz orderitemz) {
		getOrderitemzs().add(orderitemz);
		orderitemz.setOrderz(this);

		return orderitemz;
	}

	public Orderitemz removeOrderitemz(Orderitemz orderitemz) {
		getOrderitemzs().remove(orderitemz);
		orderitemz.setOrderz(null);

		return orderitemz;
	}

	public List<Shippingaddressz> getShippingaddresszs() {
		return this.shippingaddresszs;
	}

	public void setShippingaddresszs(List<Shippingaddressz> shippingaddresszs) {
		this.shippingaddresszs = shippingaddresszs;
	}

	public Shippingaddressz addShippingaddressz(Shippingaddressz shippingaddressz) {
		getShippingaddresszs().add(shippingaddressz);
		shippingaddressz.setOrderz(this);

		return shippingaddressz;
	}

	public Shippingaddressz removeShippingaddressz(Shippingaddressz shippingaddressz) {
		getShippingaddresszs().remove(shippingaddressz);
		shippingaddressz.setOrderz(null);

		return shippingaddressz;
	}

}