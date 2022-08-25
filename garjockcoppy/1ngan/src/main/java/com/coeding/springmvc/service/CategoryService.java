package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Category;

public interface CategoryService {
	Category getCategoryById(int id);

	List<Category> listCategory();

	
}
