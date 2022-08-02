package vu.dto;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
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

	private BigDecimal paymentMethod;

	private BigDecimal shippingPrice;

	private BigDecimal taxPrice;

	private BigDecimal totalPrice;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="order")
	private List<Orderitem> orderitems;

	//bi-directional many-to-one association to Shippingaddress
	@OneToMany(mappedBy="order")
	private List<Shippingaddress> shippingaddresses;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public BigDecimal getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(BigDecimal paymentMethod) {
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setOrder(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setOrder(null);

		return orderitem;
	}

	public List<Shippingaddress> getShippingaddresses() {
		return this.shippingaddresses;
	}

	public void setShippingaddresses(List<Shippingaddress> shippingaddresses) {
		this.shippingaddresses = shippingaddresses;
	}

	public Shippingaddress addShippingaddress(Shippingaddress shippingaddress) {
		getShippingaddresses().add(shippingaddress);
		shippingaddress.setOrder(this);

		return shippingaddress;
	}

	public Shippingaddress removeShippingaddress(Shippingaddress shippingaddress) {
		getShippingaddresses().remove(shippingaddress);
		shippingaddress.setOrder(null);

		return shippingaddress;
	}

}