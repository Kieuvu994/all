package com.coeding.springmvc.entity;

public class Category {
	private int _id;
	private String category_name;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		return category_name;
	}
	public void setName(String name) {
		this.category_name = name;
	}
	
}
