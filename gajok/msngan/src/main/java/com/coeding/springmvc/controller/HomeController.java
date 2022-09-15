package com.coeding.springmvc.controller;

import java.util.List;
import java.util.Locale;



import org.springframework.beans.factory.annotation.Autowired;


//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.coeding.springmvc.entity.Category;
import com.coeding.springmvc.entity.Product;
import com.coeding.springmvc.service.impl.CategoryServiceImpl;
import com.coeding.springmvc.service.impl.ProductServiceImpl;

@Controller
public class HomeController {
	
	
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private ProductServiceImpl productService;
	
	
	

	
	@RequestMapping(value = {"/home","/"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<Category> listCategory = categoryService.listCategory();
		model.addAttribute("listCategory", listCategory );
		
		List<Product> listProduct = productService.listProduct();
		model.addAttribute("listProduct", listProduct );
		
		List<Product> listLastProduct = productService.listLastProduct();
		model.addAttribute("listLastProduct",listLastProduct);
		
		List<Product> listTopRatedProduct = productService.listTopRatedProduct();
		model.addAttribute("listTopRatedProduct",listTopRatedProduct);
		
		List<Product> listTopReviewProduct = productService.listTopReviewProduct();
		model.addAttribute("listTopReviewProduct",listTopReviewProduct);

		
		return "index";
	}
	
	
}




















