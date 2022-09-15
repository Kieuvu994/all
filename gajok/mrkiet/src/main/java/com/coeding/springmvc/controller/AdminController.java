//package com.coeding.springmvc.controller;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.DateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//import java.util.Optional;
//
//import javax.servlet.ServletContext;
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.coeding.springmvc.config.ApplicationProperty;
//import com.coeding.springmvc.dto.ProductDTO;
//import com.coeding.springmvc.entity.Categoryz;
//import com.coeding.springmvc.entity.Productz;
//import com.coeding.springmvc.service.CategoryService;
//import com.coeding.springmvc.service.ProductService;
//import com.coeding.springmvc.service.UserService;
//
//@Controller
//public class AdminController {
//	
//	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
//
//	//private static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";
//	private static String uploadDir = "/WEB-INF/classes/static/images";
//
//	@Autowired
//	ServletContext ctx;
//	
//	@Autowired
//	CategoryService cateService;
//	
//	@Autowired
//	ProductService prodService;
//	
//	@Autowired
//	UserService userService;
//
//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
//	public String adminHome(Locale locale, Model model) {
//		logger.info("Welcome admin! The client locale is {}.", locale);
//		
//		logger.info("Welcome admin! The client locale is {}.", ApplicationProperty.userName);
//		logger.info("Welcome admin! The client locale is {}.", ApplicationProperty.userEmail);
//		return "adminHome";
//	}
//	
//	@RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
//	public String getCate(Locale locale, Model model) {
//		model.addAttribute("categories", cateService.findAll());
//		logger.info("Welcome categories! The client locale is {}.", locale);
//		
//		logger.info("Welcome categories! The client locale is {}.", ApplicationProperty.userName);
//		logger.info("Welcome categories! The client locale is {}.", ApplicationProperty.userEmail);
//		return "categories";
//	}
//	
//	@RequestMapping(value = "/admin/categories/add", method = RequestMethod.GET)
//	public String getCateAdd(Model model) {
//		model.addAttribute("category", new Categoryz());
//		return "categoriesAdd";
//	}
//	
//	@PostMapping("/admin/categories/add")
//	public String postCateAdd(@ModelAttribute("category") Categoryz category) {
//		cateService.create(category);
//		return "redirect:/admin/categories";
//	}
//	
//	@GetMapping("/admin/categories/delete/{id}")
//	public String deleteCate(@PathVariable int id) {
//		cateService.delete(id);
//		return "redirect:/admin/categories";
//	}
//	
//	@GetMapping("/admin/categories/update/{id}")
//	public String updateCate(@PathVariable int id, Model model) {
//		Optional<Categoryz> category = cateService.findById(id);
//		if (category.isPresent()) {
//			model.addAttribute("category", category.get());
//			return "categoriesAdd";
//		}else {
//			return "404";
//		}
//		
//	}
//	
//	//PRODUCT SECTION
//	@GetMapping("/admin/products")
//	public String getPro(Model model) {
//		
//		model.addAttribute("products", prodService.findAll());
//		return "products";
//	}
//	
//	@GetMapping("/admin/products/add")
//	public String getProAdd(Model model) {
//		model.addAttribute("productDTO", new ProductDTO());
//		model.addAttribute("categories", cateService.findAll());
//		return "productsAdd";
//	}
//	
//	//not yet
//	@PostMapping("/admin/products/add")
////	public String postProAdd(@ModelAttribute("product") ProductDTO product,
////	@RequestParam("image") MultipartFile file,
////	@RequestParam("imgName") String imgName) throws IOException {
//	public String postProAdd(ProductDTO product) throws IOException {
//		
//		Productz prod = new Productz();
//		prod.setName(product.getName());
//		prod.setCategoryz(cateService.findById(product.getCategoryId()).get());
//		prod.setPrice(product.getPrice());
//		prod.setDescription(product.getDescription());
//		MultipartFile file = product.getImage();
//		String imgUUID = file.getOriginalFilename();
//		if (!file.isEmpty()) {
//			String realPath = ctx.getRealPath(uploadDir);//+uploadDir;
//			Path fileNameAndPath = Paths.get(realPath, File.separator+imgUUID);
//			System.err.println(fileNameAndPath);
//			Files.write(fileNameAndPath, file.getBytes());
//		}
//		prod.setImage(imgUUID);
//		// TODO: how to set user_id? maybe login user's id
//		prod.setUserz( userService.findById(3));
//		prodService.create(prod);
//		
//		return "redirect:/admin/products";
//	}
//	
//	@GetMapping("/admin/product/delete/{id}")
//	public String deleteProd(@PathVariable int id) {
//		prodService.delete(id);
//		return "redirect:/admin/products";
//	}
//	
//	//not yet
//	@GetMapping("/admin/product/update/{id}")
//	public String updateProd(@PathVariable int id, Model model) {
//		Productz product = prodService.findById(id).get();
//		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setName(product.getName());
//		productDTO.setCategoryId(product.getCategoryz().getId());
//		productDTO.setPrice(product.getPrice());
//		productDTO.setDescription(product.getDescription());
////		productDTO.setImage(product.getImage());
//		
//		model.addAttribute("categories", cateService.findAll());
//		model.addAttribute("products", productDTO);
//		
//		return "productsEdit";
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
