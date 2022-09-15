package com.coeding.springmvc.repository;

import java.util.List;
import java.util.Optional;

import com.coeding.springmvc.entity.Userz;

public interface UserRepository {

	Userz findById(int id);
	List<Userz> findAll();
	String create(Userz pojo);
	String update(Userz pojo);
	String delete(int id);
	
	Userz findUserByEmail(String email);
	Userz findByUsername(String username);
}
