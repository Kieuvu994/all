package com.coeding.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coeding.springmvc.entity.Category;
import com.coeding.springmvc.entity.Product;
import com.coeding.springmvc.service.CategoryService;
import com.coeding.springmvc.service.ProductService;
import com.coeding.springmvc.serviceImpl.CategoryServiceImpl;



@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;


	@RequestMapping(value = "category", method = RequestMethod.GET)
	public String allCategory(Model model) {

		List<Category> list;
		list = categoryService.findAll();
		model.addAttribute("listCategory", list);

		return "category";
	}
	
	
	

}
