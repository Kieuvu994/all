package com.coeding.springmvc.dto;

/**
 * @author vu
 *
 * */
public class LoginUser {

	
	private String username;
	private String password;
	
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginUser(String password, String username) {
		super();
		
		this.username = username;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "{\"password\"=\"" + password + "\", \"username\"=\"" + username + "\"}";
	}
	
	
}
