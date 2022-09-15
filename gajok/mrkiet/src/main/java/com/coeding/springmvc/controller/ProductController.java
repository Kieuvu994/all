//package com.coeding.springmvc.controller;
//
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.coeding.springmvc.config.ApplicationProperty;
//import com.coeding.springmvc.entity.Product;
//import com.coeding.springmvc.service.ProductServiceImpl;
//
//@Controller
////@RequestMapping("products")
//public class ProductController {
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//	// step 3. spring jdbc - jdbctemplate
//	private JdbcTemplate jdbc;
//	// step 5. spring+mybatis
//	@Autowired
//	private SqlSessionFactory sessionFactory;
//	
//	@Autowired
//	private ProductServiceImpl productService;
//	
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbc = new JdbcTemplate(dataSource);
//	}
//	
//	@RequestMapping(value = "products", method = RequestMethod.GET)
//	public String allProduct(Model model) {
//		
//		List<Product> list = productService.listProduct();
//		model.addAttribute("listProduct", list );
//		
//		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userName);
//		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userEmail);
//
//
//
//	
//		return "allProduct";
//	}
//	@RequestMapping(value = "detail", method = RequestMethod.GET)
//	public String getProductById(Model model) {
//		//int id = (int)model.getAttribute("id");
//		
////		Product product = productService.getProductById(4);
////		model.addAttribute("product", product );
//		
//		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userName);
//		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userEmail);
//
//
//
//	
//		return "detailProduct";
//	}
//}
