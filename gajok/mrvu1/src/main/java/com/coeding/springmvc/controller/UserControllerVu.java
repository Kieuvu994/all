package com.coeding.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coeding.springmvc.dto.UserDto;
import com.coeding.springmvc.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserControllerVu {
	
	private static final Logger logger = LoggerFactory.getLogger(UserControllerVu.class);
	@Autowired
	private UserService service;

	@GetMapping("/list")
	public String userlist(Model model,HttpSession session) {
		List<UserDto> list = service.listUser();
		model.addAttribute("users", list);
		
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		UserDto user = service.getUserDtoByUsername(username);
		if (user != null && !user.getUsername().isEmpty()) {
			if (user.getIsActive() != 0) {
				model.addAttribute("profile", user);
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
			}
		}else
			return "redirect:/login";
		
		
		return "user-listuser";
	}

	@GetMapping("/delete")
	public String userdelete(@RequestParam("username") String username, Model model) {
		UserDto dto = service.getUserDtoByUsername(username);
		int rs = service.deleteUser(dto.getId());
		String message = "Success delete";
		if (rs != 1)
			message = "Don't Success";
		model.addAttribute("message", message);
		System.out.println(message);
		return "redirect:/admin/user/list";
	}// user-updatefrom

	@GetMapping("/update")
	public String updateuser(@RequestParam("username") String username1, Model model ,HttpSession session) {
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		UserDto user = service.getUserDtoByUsername(username);
		if (user != null && !user.getUsername().isEmpty()) {
			if (user.getIsActive() != 0) {
				model.addAttribute("profile", user);
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
			}
		}else
			return "redirect:/login";
		
		
		
		try {
			UserDto dto = service.getUserDtoByUsername(username1);
			if (dto == null)
				return "redirect:/admin/user/list";

			model.addAttribute("userdto", dto);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "user-updateuser";

	}

	@PostMapping("/update")
	public String updatefrom(UserDto user1, Model model ,HttpSession session) {
		System.out.println(user1.toString());
//		int id=service.getIdByUsername(user.getUsername());
//		int rs= service.deleteUser(id);
		int rs = service.updateUser(user1);
		String message = "Success Update";
		if (rs != 1)
			message = "Don't Update";
		model.addAttribute("message", message);
		System.out.println(message);
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		UserDto user = service.getUserDtoByUsername(username);
		if (user != null && !user.getUsername().isEmpty()) {
			if (user.getIsActive() != 0) {
				model.addAttribute("profile", user);
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
			}
		}else
			return "redirect:/login";
		
		
		
		return "redirect:/admin/user/list";
	}

	@GetMapping("/resetpassword")
	public String resetpassword(@RequestParam("username") String username1, Model model,HttpSession session) {
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		UserDto user = service.getUserDtoByUsername(username);
		if (user != null && !user.getUsername().isEmpty()) {
			if (user.getIsActive() != 0) {
				model.addAttribute("profile", user);
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
			}
		}else
			return "redirect:/login";

		int rs = service.resetpassword(username1);
		String message = "Success Reset";
		if (rs != 1)
			message = "Don't Reset";
		model.addAttribute("message", message);
		System.out.println(message);
		return "redirect:/admin/user/list";
	}

	@GetMapping("/add")
	public String adduser(Model model,HttpSession session) {
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		UserDto user = service.getUserDtoByUsername(username);
		if (user != null && !user.getUsername().isEmpty()) {
			if (user.getIsActive() != 0) {
				model.addAttribute("profile", user);
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
			}
		}else
			return "redirect:/login";
		System.out.println("is add");
		model.addAttribute("userdto", new UserDto());
		return "user-adduser";
	}

	@PostMapping("/add")
	public String postadduser(UserDto userdao) {
		System.out.println(userdao.getUsername());
		int in = service.addUser(userdao);
		if (in == 1)
			return "redirect:/admin/user/list";
		else
			return "redirect:/admin/user/add";
	}

	@GetMapping("/search")
	public String search(Model model,HttpSession session) {
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		UserDto user = service.getUserDtoByUsername(username);
		if (user != null && !user.getUsername().isEmpty()) {
			if (user.getIsActive() != 0) {
				model.addAttribute("profile", user);
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
			}
		}else
			return "redirect:/login";
		return "user-listuser";
	}

	@PostMapping("/search") // find user name, name lastname,....
	public String search(@RequestParam("query") String Key, Model model,HttpSession session) {
		System.out.println("search ---->"+Key);
		if (Key != "") {
			Key = Key.replace(" ", "%");
			Key = Key.replace("_", "%");
			Key = Key.replace("-", "%");
			String key = "%" + Key + "%";
			System.out.println(key + "==============");
			List<UserDto> list = service.getUsersWithKey(key);
			model.addAttribute("users", list);
			String username = (String) session.getAttribute("user");
			System.out.println(username);
			UserDto user = service.getUserDtoByUsername(username);
			if (user != null && !user.getUsername().isEmpty()) {
				if (user.getIsActive() != 0) {
					model.addAttribute("profile", user);
				} else {
					
					model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
				}
			}else
				return "redirect:/login";
		}
		return "user-listuser";
	}
}
