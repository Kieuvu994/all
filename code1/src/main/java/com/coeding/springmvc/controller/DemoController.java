package com.coeding.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

//@Controller
public class DemoController {
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "index";
	}
	@GetMapping("/{page}")
	public String Login(@PathVariable String page) {
		return "page";
		
	}

//	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
//	public String login(Locale locale, Model model) {
//		String url = "http://localhost:8080/vu/api/users/login";
//		try {
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://covid-193.p.rapidapi.com/countries"))
//				.header("X-RapidAPI-Key", "SIGN-UP-FOR-KEY")
//				.header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
//				.method("GET", HttpRequest.BodyPublishers.noBody())
//				.build();
//		HttpResponse<String> response;
//		
//			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//			System.out.println(response.body());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return "login";
//	}
//
//	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
//	public String logout(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate);
//
//		return "index";
//	}

}
