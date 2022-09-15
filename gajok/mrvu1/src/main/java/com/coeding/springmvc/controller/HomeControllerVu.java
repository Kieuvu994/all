package com.coeding.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coeding.springmvc.dto.CreateUserDto;
import com.coeding.springmvc.dto.LoginUser;
import com.coeding.springmvc.dto.UserDto;
import com.coeding.springmvc.service.UserService;

@Controller
public class HomeControllerVu {
	private static final Logger logger = LoggerFactory.getLogger(HomeControllerVu.class);
	@Autowired
	private UserService service;

	@RequestMapping(value = { "/admin/home", "/admin", "/admin/index","/","/home","" }, method = RequestMethod.GET)
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
				if(user.getIsStaff()>0 || user.getIsSuperuser()>0 )
				return "index";
				else return "redirect:../ngan/home";
			} else {
				
				model.addAttribute("message","tai khoan cua ban da bi khoa vui long lien he CSKH");
				return "pages-error-404";
			}
		}else
			return "redirect:/login";
	}

	@GetMapping({ "/login", "/admin/login" })
	public String loginn(Model model,HttpSession session) {
		if (session.getAttribute("user") != null)
			session.removeAttribute("user");
		return "pages-login";
	}

	@GetMapping({ "/logout", "/admin/logout" })
	public String logout(Model model, HttpSession session) {
		if (session.getAttribute("user") != null)
			session.removeAttribute("user");
		return "pages-login";
	}

	@PostMapping("/login")
//	public String saveblog(@ModelAttribute("user") LoginUser user, Principal principal) {
	public String saveblog(LoginUser user, HttpSession session) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		int in=0;
		try {
			in = service.loginUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
			return "redirect:/admin";

		} else
			return "redirect:/login";
	}

	@GetMapping({ "/register" })
	public String register(Model model) {
//		CreateUserDto user = new CreateUserDto();
//		model.addAttribute("user", user);
		return "pages-register";
	}

	@PostMapping({ "/register" })
	public String registercheck(CreateUserDto dto) {
		
		int in =0;
		try {
			in= service.createUser(dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
	@GetMapping("/user/update")
	public String updateuser(@RequestParam("username") String username, Model model) {
		UserDto dto = service.getUserDtoByUsername(username);
		if (dto == null)
			return "redirect:/user/login";

		model.addAttribute("profile", dto);

		return "users-profile";

	}
	@PostMapping("/user/update")
	public String updatefrom(UserDto user, Model model) {
		System.out.println(user.toString());
		int rs=0;String message = "Success Update";
		try {
			UserDto userf= service.getUserDtoByUsername(user.getUsername());
			user.setDateJoined(userf.getDateJoined());
			user.setIsActive((byte) 1);
			user.setIsStaff(userf.getIsStaff());
			user.setIsSuperuser(userf.getIsSuperuser());
//			int id=service.getIdByUsername(user.getUsername());
//			int rs= service.deleteUser(id);
			rs = service.updateUser(user);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (rs != 1)
			message = "Don't Update";
		model.addAttribute("message", message);
		System.out.println(message);
		return "redirect:/user/profile";
	}
	@GetMapping("/user/changepw")
	public String changpass(Model model,HttpSession session) {
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
//		try {
//			String username=(String)session.getAttribute("user");
//			UserDto dto = service.getUserDtoByUsername(username);
//			if (dto == null || username==null)
//				return "redirect:/user/login";
//
//			model.addAttribute("profile", dto);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

		return "users-profile";

	}
	@PostMapping("/user/changepw")
	public String changpass(HttpSession session, Model model,
			@Param("password") String password,
			@Param("newpassword") String newpassword,
			@Param("renewpassword") String renewpassword
			) {
		System.out.println(password +"----->"+newpassword+"------->"+renewpassword);
		String username=(String)session.getAttribute("user");
		System.out.println("username-->"+username);
		LoginUser user =new LoginUser();
		user.setUsername(username);
		user.setPassword(password);
		int in=0;
		try {
			in = service.loginUser(user);
			System.out.println("check userpw -->"+in);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(in==1 && newpassword.equals(renewpassword)) {
			user.setPassword(newpassword);
			System.out.println("newpass--->"+ user.getPassword());
			int ipw = service.changePW(user);
			if(ipw==1) {
			System.out.println("change pw success");
			return "users-profile";
			}
		}
		return "redirect:/user/profile";
	}
}
