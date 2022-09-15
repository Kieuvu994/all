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
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public byte getIsActive() {
		return isActive;
	}
	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}
	public byte getIsStaff() {
		return isStaff;
	}
	public void setIsStaff(byte isStaff) {
		this.isStaff = isStaff;
	}
	public byte getIsSuperuser() {
		return isSuperuser;
	}
	public void setIsSuperuser(byte isSuperuser) {
		this.isSuperuser = isSuperuser;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}