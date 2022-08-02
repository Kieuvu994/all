package mrvu.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mrvu.dto.UserDto;
import mrvu.interfaces.UserService;
import mrvu.jpa.User;
import mrvu.service.UserServiceVu;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RestUser {
	
	private UserService service;
	{
		service = new UserServiceVu();
	}
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