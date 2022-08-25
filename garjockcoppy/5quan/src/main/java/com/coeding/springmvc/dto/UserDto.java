package com.coeding.springmvc.dto;

import java.util.Date;

import com.coeding.springmvc.entity.User;

public class UserDto {
	private String email;
	private byte isActive;
	private byte isStaff;
	private byte isSuperuser;
	private Date lastLogin;
	private String lastName;
	private String password;
	private String username;	// is Unique
	private Date dateJoined;
	
	public UserDto(String email, byte isActive, byte isStaff, byte isSuperuser, Date lastLogin, String lastName,
			String password, String username, Date dateJoined) {
		super();
		this.email = email;
		this.isActive = isActive;
		this.isStaff = isStaff;
		this.isSuperuser = isSuperuser;
		this.lastLogin = lastLogin;
		this.lastName = lastName;
		this.password = password;
		this.username = username;
		this.dateJoined = dateJoined;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(User user) {
		System.out.println("5. initialize UserDto instance from User");
		this.email = user.getEmail();
		this.isActive = user.getIsActive();
		this.isStaff = user.getIsStaff();
		this.isSuperuser = user.getIsSuperuser();
		this.lastLogin = user.getLastLogin();
		this.lastName = user.getLastName();
		this.username = user.getUsername();		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	
}
