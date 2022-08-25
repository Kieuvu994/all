package com.coeding.springmvc.restcontroller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.coeding.springmvc.dto.CreateUserDto;
import com.coeding.springmvc.dto.LoginUser;
import com.coeding.springmvc.dto.UserDto; 
import com.coeding.springmvc.service.UserService;
/**
 * @author vu
 *
 * */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RestUser {
	@Autowired
	private UserService service;
	
	
	
	@GetMapping("/users/search/{key}")//find user name, name lastname,....
	public List<UserDto> getUsersWithKey(@PathVariable("key") String Key ) {
		if(Key != "") {
		Key=Key.replace(" ", "%");
		Key=Key.replace("_", "%");
		Key=Key.replace("-","%");
	 	String key = "%"+Key+"%";
	 	System.out.println(key +"==============");
		return service.getUsersWithKey(key);}
		return null;
	}
	@GetMapping("/users/list")//xong
	public List<UserDto> listUser(){
		
			return service.listUser();
	}
//	@GetMapping("/users/list")
//	public List<User> listUser(HttpSession session){
//		String role = (String)session.getAttribute("userRole");
//		if( role.equals("ADMIN") )
//			return service.listUser();
//		else return null;
//		
//	}
	@PostMapping("/users/login")
	public String login(@RequestBody LoginUser lou ) 	{
		int in = service.loginUser(lou);
		String message="login thanh cong";
		if(in == 2) message="sai password";
		if(in==0) message="user khong ton tai";
		return message;
		
	}
	
	@GetMapping("/users/delete/{id}")//xong
	public String deleteUser(@PathVariable("id") Integer id ) {
		String message = "Success delete";
		if( service.deleteUser(id) == 0 ) {
			System.out.println("khong co delete");
			message = "khong co delete";
		}
		return message;
	}
	/**
	 * 
	 * @param dto
	 * @return "message"
	 */
	@PostMapping("/users/register")//xong
	public String createUser(@RequestBody CreateUserDto dto) {
		int in =service.createUser(dto);
		dto.setIsActive((byte) 1);
		dto.setIsStaff((byte) 0);
		dto.setIsSuperuser((byte) 0);
		String message;
		switch (in) {
		case 1:
			message= "success create user!!";
			break;
		case 2:
			message= "loi user name";
			break;
		default:
			message= "don't success";
			break;
		}
		return message;
	}
	
	@PostMapping("/users/update")//xong9/8
	public String updateUser(@RequestBody UserDto dto) {
		int in =service.updateUser(dto);
		System.out.println("------------>>>>"+in);
		String message;
		switch (in) {
		case 1:
			message= "success update user!!";
			 break;
		default:
			message= "don't success";
			break;
		}
		return message;
	}
	
}