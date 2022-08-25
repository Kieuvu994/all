package com.coeding.springmvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Category;
import com.coeding.springmvc.dao.CategoryDao;
import com.coeding.springmvc.service.CategoryService;

/**
 * 
 * @author Quan
 *
 */

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}

	@Override
	public List<Category> findAllById(int id) {
		
		return categoryDao.findAllById(id);
	}

	@Override
	public List<Category> findByName(String name) {
		
		return categoryDao.findByName(name);
	}

	@Override
	public int update(int id) {
		categoryDao.update(id);
		return 1;
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
		
	}

}
