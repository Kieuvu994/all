package com.coeding.springmvc.controller;

import java.util.Locale;


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

import com.coeding.springmvc.config.ApplicationProperty;
import com.coeding.springmvc.global.GlobalDara;
import com.coeding.springmvc.service.CategoryService;
import com.coeding.springmvc.service.ProductService;

@Controller
public class ShopGridController {

	private static final Logger logger = LoggerFactory.getLogger(ShopGridController.class);
	
	@Autowired
	private CategoryService cateService;
	
	@Autowired
	private ProductService prodService;
	
	@RequestMapping(value = "/shop-grid", method = RequestMethod.GET)
	public String shopGrid(Locale locale, Model model) {
		logger.info("Welcome shop! The client locale is {}.", locale);
		
		model.addAttribute("categories", cateService.findAll());
		model.addAttribute("products", prodService.findAll());
		model.addAttribute("productCount", prodService.findAll().size());
		model.addAttribute("cartCount", GlobalDara.cart.size());
		
		return "shop-grid";
	}
	
	@GetMapping("/shop-grid/category/{id}")
	public String shopByCategory(Model model, @PathVariable int id) {
		logger.info("Welcome /shop/category/{id}! The client locale is {}.");
		
		model.addAttribute("categories", cateService.findAll());
		model.addAttribute("products", prodService.findAllProductByCategoryId(id));//not yet
		model.addAttribute("cartCount", GlobalDara.cart.size());
		
		return "shop-grid";
	}
	
	@GetMapping("/shop-grid/shop-details/{id}")
	public String shopDetail(Model model, @PathVariable int id) {
		
		model.addAttribute("products", prodService.findById(id).get());//not yet
		model.addAttribute("cartCount", GlobalDara.cart.size());
		
		return "shop-details";
	}
	
	@GetMapping("/contact")
	public String contact() {
		
		return "contact";
	}

}
