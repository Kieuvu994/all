package com.coeding.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dao.CategoryDao;
import com.coeding.springmvc.dao.ProductDao;
import com.coeding.springmvc.entity.Category;
import com.coeding.springmvc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	 @Autowired
		private CategoryDao categoryDao;
	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> listCategory() {
		return categoryDao.getAllCategory();
	}
	
}
