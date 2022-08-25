package com.coeding.springmvc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coeding.springmvc.dto.UserDto;
import com.coeding.springmvc.entity.User;
import com.coeding.springmvc.service.UserService;
import com.coeding.springmvc.serviceImpl.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RestUser {
	@Autowired
	private UserServiceImpl service;
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") Integer id ) {
		return service.getUserById(id);
	}
	@GetMapping("/users/list")
	public List<User> listUser(){
		return service.listUser();
		
	}
	@GetMapping("/users/delete/{id}")
	public int deleteUser(@PathVariable("id") Integer id ) {
		return service.deleteUser(id);
	}
	@GetMapping("/users/update/{id}")
	public int updateUser(@PathVariable("id") Integer id, UserDto dto) {
		return service.updateUser(dto);
	}
}