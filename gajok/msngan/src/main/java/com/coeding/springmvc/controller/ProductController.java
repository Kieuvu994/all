package com.coeding.springmvc.controller;



import java.io.Console;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coeding.springmvc.entity.Category;
import com.coeding.springmvc.entity.Product;
import com.coeding.springmvc.entity.Review;
import com.coeding.springmvc.entity.Size;
import com.coeding.springmvc.entity.Topping;
import com.coeding.springmvc.service.CategoryService;
import com.coeding.springmvc.service.ProductService;
import com.coeding.springmvc.service.ReviewService;
import com.coeding.springmvc.service.SizeService;
import com.coeding.springmvc.service.ToppingService;


@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private SizeService sizeService;
	
	@Autowired
	private ToppingService toppingService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String home(@PathVariable int id,Model model) {
		
	
		Product product = productService.getProductById(id);
		model.addAttribute("product",product);
		System.out.print(product.toString());
		
		List<Size> listSize = sizeService.listSize();
		model.addAttribute("listSize", listSize);
		
		List<Topping> listTopping = toppingService.listTopping();
		model.addAttribute("listTopping", listTopping);
		
		List<Review> listReview = reviewService.getReviewById(product.get_id());
		model.addAttribute("listReview", listReview);
		
		List<Product> listRelated = productService.listProductByCategory(product.get_id());
		model.addAttribute("listRelated", listRelated);
		
		return "product-detail";
		
	}
	
	@RequestMapping(value = {"/shops"}, method = RequestMethod.GET)
	public String shops(@RequestParam("page") String page ,Model model) {
		
		int currentPage = Integer.valueOf(page);
		
		List<Product> listProductPage = productService.getProductPaging(currentPage, 6);
		model.addAttribute("listProductPage", listProductPage);
		
	    int[] countPage = productService.countPage();
		model.addAttribute("countPage", countPage);
		
		List<Category> listCategory = categoryService.listCategory();
		model.addAttribute("listCategory", listCategory );
		
		return "shop-grid";
	}
	@RequestMapping(value = {"/shops/search"}, method = RequestMethod.GET)
	public String search(@RequestParam("search") String search,Model model) {
		
	
		List<Category> listCategory = categoryService.listCategory();
		model.addAttribute("listCategory", listCategory );
		
		
		List<Product> searchList = productService.listSearchProduct(search);
		model.addAttribute("searchList",searchList);

		System.out.print(searchList.size());
		System.out.print(search);
		
		return "shop-grid";
	}
}




















