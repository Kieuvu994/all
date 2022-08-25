package com.coeding.springmvc.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the review database table.
 * 
 */

public class Review  {
	private int id;
	private String comment;
	private Date createdAt;
	private String name;
	private int rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}