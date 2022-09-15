package com.coeding.springmvc.repository;

import java.util.List;
import java.util.Optional;

import com.coeding.springmvc.entity.Rolez;

public interface RoleRepository {

	Rolez findById(int id);
	List<Rolez> findAll();
	String create(Rolez pojo);
	String update(Rolez pojo);
	String delete(int id);
	
	Rolez findByRole(String role);
}
