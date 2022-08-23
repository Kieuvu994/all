package com.coeding.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.coeding.springmvc.dto.CreateUserDto;
import com.coeding.springmvc.dto.LoginUser;
import com.coeding.springmvc.dto.UserDto;
import com.coeding.springmvc.security.CustomAuthenticationProvider;
import com.coeding.springmvc.service.UserService;

@Controller
@RequestMapping("/")
public class HomeControllerVu {
	private static final Logger logger = LoggerFactory.getLogger(HomeControllerVu.class);
	@Autowired
	private UserService service;
	
	@Autowired
	private  CustomAuthenticationProvider customAuthenticationProvider;

	@RequestMapping(value = { "/admin/home", "/admin", "/admin/index" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		UserDto user = service.getUserDtoByUsername(username);
		if (user != null && !user.getUsername().isEmpty()) {
			if (user.getIsActive() != 0) {
				model.addAttribute("profile", user);
				return "index";
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
				return "pages-error-404";
			}
		}else
			return "redirect:/login";
	}

	@GetMapping({ "/login", "/admin/login" })
	public String loginn(Model model) {
		LoginUser user = new LoginUser("admin", "admin");
		model.addAttribute("user", user);
		return "pages-login";
	}

	@GetMapping({ "/logout", "/admin/logout" })
	public String logout(Model model, HttpSession session) {
		if (session.getAttribute("user") != null)
			session.removeAttribute("user");
		return "pages-login";
	}

	@PostMapping("/j_spring_security_check")
//	public String saveblog(@ModelAttribute("user") LoginUser user, Principal principal) {
	public String saveblog(LoginUser user, HttpSession session) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		int in = service.loginUser(user);
		String message = "login thanh cong";
		if (in == 2)
			message = "sai password";
		if (in == 0)
			message = "user khong ton tai";
		System.out.println(message);
		if (in == 1) {
			session.setAttribute("user", user.getUsername());
			System.out.println(session.getAttribute("user"));
			System.out.println(session.getId());
			// session.removeAttribute("user")
			return "redirect:/user/profile";

		} else
			return "redirect:/login";
	}

	@GetMapping({ "/register" })
	public String register(Model model) {
		CreateUserDto user = new CreateUserDto();
		model.addAttribute("user", user);
		return "pages-register";
	}

	@PostMapping({ "/register" })
	public String registercheck(CreateUserDto dto) {
		int in = service.createUser(dto);
		System.out.println(in);
		String message;
		switch (in) {
		case 1:
			message = "success create user!!";
			break;
		case 2:
			message = "loi user name";
			break;
		default:
			message = "don't success";
			break;
		}
		System.out.println(message);
		if (in == 1)
			return "redirect:/";
		else
			return "redirect:/register";
	}

	@GetMapping({ "/user/profile" })
	public String profile(Model model, HttpSession session) {
		String username = (String) session.getAttribute("user");
		System.out.println(username);
		UserDto user = service.getUserDtoByUsername(username);
		if (user != null && !user.getUsername().isEmpty()) {
			if (user.getIsActive() != 0) {
				model.addAttribute("profile", user);
				return "users-profile";
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
				return "pages-error-404";
			}
		}else
			return "redirect:/login";
		
	}
}
