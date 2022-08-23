package com.coeding.springmvc.entity;

import java.util.Date;


/**
 * The persistent class for the user database table.
 * 
 */

public class User  {
	private int id;
	private Date dateJoined;
	private String email;
	private String firstName;
	private byte isActive;
	private byte isStaff;
	private byte isSuperuser;
	private Date lastLogin;
	private String lastName;
	private String password;
	private String username;
	private String image;
	
	
	public User() {
		super();
	}
	public User(int id, Date dateJoined, String email, String firstName, byte isActive, byte isStaff, byte isSuperuser,
			Date lastLogin, String lastName, String password, String username, String image) {
		super();
		this.id = id;
		this.dateJoined = dateJoined;
		this.email = email;
		this.firstName = firstName;
		this.isActive = isActive;
		this.isStaff = isStaff;
		this.isSuperuser = isSuperuser;
		this.lastLogin = lastLogin;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public byte getIsActive() {
		return isActive;
	}
	public byte getIsStaff() {
		return isStaff;
	}
	public byte getIsSuperuser() {
		return isSuperuser;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public String getImage() {
		return image;
	}
	
}