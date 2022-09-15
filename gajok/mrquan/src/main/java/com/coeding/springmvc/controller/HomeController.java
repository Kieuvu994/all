package com.coeding.springmvc.controller;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String login(String username, String password, Locale locale, Model model) {
		String url = "http://localhost:8080/vu/api/users/login";
		// make json string
		String loginuser = "{\"username\": " + username + ", \"password\" : " +  password + "}";

		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
//					.header("X-RapidAPI-Key", "7715bb2ca6msh6cb7ff404bf4d93p15b063jsn78401aa1ae5f")
//					.header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
//					.method("GET", HttpRequest.BodyPublishers.noBody())
					.header("Content-Type", "application/json")
					.method("POST", HttpRequest.BodyPublishers.ofString(loginuser))
					.build();
			HttpResponse<String> response = 
					HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			if( "user khong ton tai".equals(response.body())){
				System.out.println(" login failed ");
			}
			// JSON string to Object
			ObjectMapper mapper = new ObjectMapper();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}

	@RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
	public String logout(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
}




















