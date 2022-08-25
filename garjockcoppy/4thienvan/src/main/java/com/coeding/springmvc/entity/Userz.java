package com.coeding.springmvc.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the userz database table.
 * 
 */
@Entity
@NamedQuery(name="Userz.findAll", query="SELECT u FROM Userz u")
public class Userz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_joined")
	private Date dateJoined;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String image;

	@Column(name="is_active")
	private byte isActive;

	@Column(name="is_staff")
	private byte isStaff;

	@Column(name="is_superuser")
	private byte isSuperuser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login")
	private Date lastLogin;

	@Column(name="last_name")
	private String lastName;

	private String password;

	private String username;

	//bi-directional many-to-one association to Orderz
	@OneToMany(mappedBy="userz")
	private List<Orderz> orderzs;

	//bi-directional many-to-one association to Productz
	@OneToMany(mappedBy="userz")
	private List<Productz> productzs;

	//bi-directional many-to-one association to Reviewz
	@OneToMany(mappedBy="userz")
	private List<Reviewz> reviewzs;

	//bi-directional many-to-many association to Rolez
	@ManyToMany(mappedBy="userzs")
	private List<Rolez> rolezs;

	public Userz(int id, Date dateJoined, String email, String firstName, String image, byte isActive, byte isStaff,
			byte isSuperuser, Date lastLogin, String lastName, String password, String username) {
		super();
		this.id = id;
		this.dateJoined = dateJoined;
		this.email = email;
		this.firstName = firstName;
		this.image = image;
		this.isActive = isActive;
		this.isStaff = isStaff;
		this.isSuperuser = isSuperuser;
		this.lastLogin = lastLogin;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
	}

	public Userz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateJoined() {
		return this.dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsStaff() {
		return this.isStaff;
	}

	public void setIsStaff(byte isStaff) {
		this.isStaff = isStaff;
	}

	public byte getIsSuperuser() {
		return this.isSuperuser;
	}

	public void setIsSuperuser(byte isSuperuser) {
		this.isSuperuser = isSuperuser;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Orderz> getOrderzs() {
		return this.orderzs;
	}

	public void setOrderzs(List<Orderz> orderzs) {
		this.orderzs = orderzs;
	}

	public Orderz addOrderz(Orderz orderz) {
		getOrderzs().add(orderz);
		orderz.setUserz(this);

		return orderz;
	}

	public Orderz removeOrderz(Orderz orderz) {
		getOrderzs().remove(orderz);
		orderz.setUserz(null);

		return orderz;
	}

	public List<Productz> getProductzs() {
		return this.productzs;
	}

	public void setProductzs(List<Productz> productzs) {
		this.productzs = productzs;
	}

	public Productz addProductz(Productz productz) {
		getProductzs().add(productz);
		productz.setUserz(this);

		return productz;
	}

	public Productz removeProductz(Productz productz) {
		getProductzs().remove(productz);
		productz.setUserz(null);

		return productz;
	}

	public List<Reviewz> getReviewzs() {
		return this.reviewzs;
	}

	public void setReviewzs(List<Reviewz> reviewzs) {
		this.reviewzs = reviewzs;
	}

	public Reviewz addReviewz(Reviewz reviewz) {
		getReviewzs().add(reviewz);
		reviewz.setUserz(this);

		return reviewz;
	}

	public Reviewz removeReviewz(Reviewz reviewz) {
		getReviewzs().remove(reviewz);
		reviewz.setUserz(null);

		return reviewz;
	}

	public List<Rolez> getRolezs() {
		return this.rolezs;
	}

	public void setRolezs(List<Rolez> rolezs) {
		this.rolezs = rolezs;
	}

}