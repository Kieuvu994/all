package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.dto.UserDto;
import com.coeding.springmvc.entity.User;

public interface UserService {

	User getUserById(Integer id);

	List<User> listUser();

	int deleteUser(Integer id);

	int updateUser(UserDto dto);
	
	int createUser(UserDto dto);

	UserDto getUser(String attribute);

}
