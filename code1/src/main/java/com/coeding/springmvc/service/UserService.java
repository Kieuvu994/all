package com.coeding.springmvc.service;

import java.util.List;

import com.coeding.springmvc.dto.CreateUserDto;
import com.coeding.springmvc.dto.LoginUser;
import com.coeding.springmvc.dto.UserDto;
/**
 * @author vu
 *
 * */

public interface UserService {
	int loginUser(LoginUser lou);
	UserDto getUserDtoByUsername(String username);

	List<UserDto> listUser();

	int deleteUser(Integer id);

	int updateUser(UserDto dto);
	
	int createUser(CreateUserDto dto);

	List<UserDto> getUsersWithKey(String key);

	int resetpassword(String username);
	int addUser(UserDto userdao);
}
