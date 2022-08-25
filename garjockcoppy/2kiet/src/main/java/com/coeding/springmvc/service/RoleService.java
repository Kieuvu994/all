package com.coeding.springmvc.service;

import java.util.List;
import java.util.Optional;

import com.coeding.springmvc.entity.Rolez;

public interface RoleService {
	Rolez findById(int id);
	List<Rolez> findAll();
	String create(Rolez pojo);
	String update(Rolez pojo);
	String delete(int id);
	
	Rolez findByRole(String role);
}
