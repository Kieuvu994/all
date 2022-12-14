package com.coeding.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeControllerVan {
	private static final Logger logger = LoggerFactory.getLogger(HomeControllerVan.class);


//	@RequestMapping(value = { "/admin/home", "/admin", "/admin/index" }, method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate);
//
//		return "index";
//	}
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome ThienVan's home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

}
		// DB connection
		// step 1. JDBC connector
//		try(Connection con = DataSourceFactory.getMysqlConnection("jdbc:mysql://localhost:3306/blog", "root", "")){
//			logger.info("{}", con);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		// step 2. Spring JDBC
//		try(Connection con = DataSourceFactory.getConnection("jdbc:mysql://localhost:3306/blog", "root", "")){
//			logger.info("{}", con);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		// step 3. Spring JDBC bean ?????? ??? injection ?????? JdbcTemplate ??????
//		logger.info("{}", jdbc);
//		jdbc.query("select * from blog_post", new RowMapper() {
//
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//		});
		// step 4. mybatis
//		BlogPostDao dao = new BlogPostDao();
		// step 5. spring+mybatis
//		logger.info("{}", session);
//		session.close();// SqlSession ??? bean ?????? ????????? ?????? ???????????? ?????? ????????? ??????.

//	@RequestMapping(value = "all", method = RequestMethod.GET)
//	public String allProduct(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
//		
//		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userName);
//		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userEmail);
//
//		// DB connection
//		// step 1. JDBC connector
////		try(Connection con = DataSourceFactory.getMysqlConnection("jdbc:mysql://localhost:3306/blog", "root", "")){
////			logger.info("{}", con);
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
//		// step 2. Spring JDBC
////		try(Connection con = DataSourceFactory.getConnection("jdbc:mysql://localhost:3306/blog", "root", "")){
////			logger.info("{}", con);
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
//		// step 3. Spring JDBC bean ?????? ??? injection ?????? JdbcTemplate ??????
////		logger.info("{}", jdbc);
////		jdbc.query("select * from blog_post", new RowMapper() {
////
////			@Override
////			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
////				// TODO Auto-generated method stub
////				return null;
////			}
////			
////		});
//		// step 4. mybatis
////		BlogPostDao dao = new BlogPostDao();
//		// step 5. spring+mybatis
////		logger.info("{}", session);
////		session.close();// SqlSession ??? bean ?????? ????????? ?????? ???????????? ?????? ????????? ??????.
//		return "allProduct";
//	}

	
	/**
	 * ????????? 3 ????????? ???????????? @ResponseBody ??? ????????? ????????? JSON ?????? ???????????? ?????? ??????
	 * ????????? ?????? ?????????????????? ResponseEntity ??? ???????????? ????????? ?????? ????????? ??????
	 * 
	 * @return
	 */
//	@GetMapping("/news/v1")
//	@ResponseBody
//	public News news1() {
//		return new News("new airport"," international airport closed");
//	}
//
//	@GetMapping("/news/v2")
//	@ResponseBody
//	public ResponseEntity<News> news2() {
//		return new ResponseEntity<News>(new News("Worldcup","good fight"), HttpStatus.OK);
//	}

	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);		
//		return "login";
//	}
//	@RequestMapping("/logout")
//	public String logout(HttpSession session){
//		SecurityContextHolder.clearContext();
//		if (session != null) {
//			session.invalidate();
//		}
//		return "login";
//	}
//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
//	public String admin(Locale locale, Model model) {
//		logger.info("Welcome Admin! {}.", locale);		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate );
//		model.addAttribute("message", "admin" );
//		
//		return "index";
//	}

	
//======================================================================================================== Agree
	

