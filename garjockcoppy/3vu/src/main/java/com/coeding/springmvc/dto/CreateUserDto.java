package com.coeding.springmvc.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author vu
 *
 * */
public class CreateUserDto {
	private String email;
	private String firstName;
	private byte isActive;
	private byte isStaff;
	private byte isSuperuser;
	private String lastName;
	private String username;
	private String password;
	private MultipartFile images;
	
	
	public CreateUserDto(String email, String firstName, byte isActive, byte isStaff, byte isSuperuser, String lastName,
			String username, String password, MultipartFile images) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.isActive = isActive;
		this.isStaff = isStaff;
		this.isSuperuser = isSuperuser;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.images = images;
	}
	public CreateUserDto(String email, String firstName, byte isStaff, byte isSuperuser,
			 String lastName, String username, String password) {
		super();
		
		this.email = email;
		this.firstName = firstName;
		this.isStaff = isStaff;
		this.isSuperuser = isSuperuser;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	public CreateUserDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getLastName() {
		return lastName;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}
	public void setIsStaff(byte isStaff) {
		this.isStaff = isStaff;
	}
	public void setIsSuperuser(byte isSuperuser) {
		this.isSuperuser = isSuperuser;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public MultipartFile getImages() {
		return images;
	}
	public void setImages(MultipartFile images) {
		this.images = images;
	}
	
}
