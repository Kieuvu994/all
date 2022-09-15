package com.coeding.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coeding.springmvc.config.ApplicationProperty;
import com.coeding.springmvc.dto.ProductDto;
import com.coeding.springmvc.entity.Category;
import com.coeding.springmvc.entity.Product;
import com.coeding.springmvc.entity.Size;
import com.coeding.springmvc.entity.Topping;
import com.coeding.springmvc.service.ProductService;
import com.coeding.springmvc.service.SizeService;
import com.coeding.springmvc.service.ToppingService;
import com.coeding.springmvc.serviceImpl.ProductServiceImpl;
import com.coeding.springmvc.serviceImpl.SizeServiceImpl;
import com.coeding.springmvc.serviceImpl.ToppingServiceImpl;



/**
 * 
 * @author Quan
 *
 */

@Controller
//@RequestMapping("products")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
// Interface based injection
	
	@Autowired
	private ProductService productService;

	@Autowired
	private ToppingService toppingService;

	@Autowired
	private SizeService sizeService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String allProduct(Model model) {
		
		
		List<Product> list = productService.listProduct();
		model.addAttribute("listProduct", list);

		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userName);
		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userEmail);

		return "allProduct";
	}

	@GetMapping(value = "/detailProduct/{id}")
	public String getProductById(Model model, @PathVariable int id) {

		Product product = productService.getProductById(id);
		model.addAttribute("detailProduct", product);

		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userName);
		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userEmail);

		return "detailProduct";
	}
	
	@RequestMapping(value = "/productByCategory/{catId}")
	public String getProductByCat(Model model, @PathVariable int catId) {
		
		List<Product> listByCat;
		listByCat = productService.findByCategory(catId);
		model.addAttribute("listByCat", listByCat);
		
		return "productByCategory";
	}

	@RequestMapping(value = "addProduct", method = RequestMethod.GET)
	public String addProduct(Model model, ProductDto productDto) {

		Product newProduct = new Product();
		newProduct.setName(productDto.getName());
		newProduct.setPrice(productDto.getPrice());
		newProduct.setDescription(productDto.getDescription());
		newProduct.setImage(productDto.getImage());
		newProduct.setCountInStock(productDto.getCountInStock());

		productService.addProductz(newProduct);

		return "addProduct";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateProduct(Model model) {

		int id = (int) model.getAttribute("id");
		productService.updateProduct(id);

		return "updateProduct";
	}

	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
	public String deleteProduct(Model model, @PathVariable int id) {
	
		productService.delete(id);
		return "allProduct";
	}

	@RequestMapping(value = "topping", method = RequestMethod.GET)
	public String allToppings(Model model) {

		List<Topping> toppingList = toppingService.findAll();
		model.addAttribute("toppingList", toppingList);
		
		return "topping";
	}

	@RequestMapping(value = "size", method = RequestMethod.GET)
	public String allSizes(Model model) {
		List<Size> sizeList = sizeService.findAll();
		model.addAttribute("sizeList", sizeList);

		return "size";
	}
}
