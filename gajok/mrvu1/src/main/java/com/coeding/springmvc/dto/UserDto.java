package com.coeding.springmvc.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
/**
 * @author vu
 *
 * */
public class UserDto {
	private int id;
	private Date dateJoined;
	private String email;
	private String firstName;
	private byte isActive;
	private byte isStaff;
	private byte isSuperuser;
	private Date lastLogin;
	private String lastName;
	private String username;
	private MultipartFile images;
	private String image;
	//get input
	public UserDto(int id, Date dateJoined, String email, String firstName, byte isActive, byte isStaff,
			byte isSuperuser, Date lastLogin, String lastName, String username,MultipartFile images) {
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
		this.username = username;
		this.images =images;
	}
	//get output
	public UserDto(int id,Date dateJoined, String email, String firstName, byte isActive, byte isStaff, byte isSuperuser,
			Date lastLogin, String lastName, String username, String image) {
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
		this.username = username;
		this.image=image;
	}
	
	public UserDto() {
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MultipartFile getImages() {
		return images;
	}
	public void setImages(MultipartFile images) {
		this.images = images;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
