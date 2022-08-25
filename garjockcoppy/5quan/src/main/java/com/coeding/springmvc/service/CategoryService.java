package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.entity.Category;

/**
 * 
 * @author Quan
 *
 */

public interface CategoryService {
	List<Category> findAll();
	List<Category> findAllById(int id);
	List<Category> findByName(String name);
	int update(int id);
	void delete(int id);
}
