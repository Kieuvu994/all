package com.coeding.springmvc.service;

import java.util.List;
import java.util.Optional;

import com.coeding.springmvc.entity.Categoryz;

public interface CategoryService {

	Optional<Categoryz> findById(int id);
	List<Categoryz> findAll();
	String create(Categoryz pojo);
	String update(Categoryz pojo);
	String delete(int id);
}
