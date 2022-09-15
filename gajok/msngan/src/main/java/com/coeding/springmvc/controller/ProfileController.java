package com.coeding.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coeding.springmvc.dto.UserDto;
import com.coeding.springmvc.service.UserService;

/**
 * 
 * user's information
 * 
 * @author Ngan
 *
 */
@Controller
@RequestMapping("/profiles")
public class ProfileController {
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
		
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		UserDto user = userService.getUser((String)session.getAttribute("PROFILE"));
		if(user.getUsername() == null || user.getUsername().isEmpty()) {
			return "redirect:/login";// prefix is Context-path
		}
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("name", user.getUsername());
		return "index";
	}
	
}




















