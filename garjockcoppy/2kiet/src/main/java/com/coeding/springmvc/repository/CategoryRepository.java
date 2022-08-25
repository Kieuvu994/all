package com.coeding.springmvc.repository;

import java.util.List;
import java.util.Optional;

import com.coeding.springmvc.entity.Categoryz;

public interface CategoryRepository {
	
	Optional<Categoryz> findById(int id);
	List<Categoryz> findAll();
	String create(Categoryz pojo);
	String update(Categoryz pojo);
	String delete(int id);
	
}
