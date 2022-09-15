package com.coeding.springmvc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.entity.Categoryz;
import com.coeding.springmvc.repository.CategoryRepository;
import com.coeding.springmvc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public Optional<Categoryz> findById(int id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.findById(id);
	}

	@Override
	public List<Categoryz> findAll() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	@Override
	public String create(Categoryz pojo) {
		// TODO Auto-generated method stub
		return this.categoryRepository.create(pojo);
	}

	@Override
	public String update(Categoryz pojo) {
		// TODO Auto-generated method stub
		return this.categoryRepository.update(pojo);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return this.categoryRepository.delete(id);
	}

}
