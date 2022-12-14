package com.coeding.springmvc.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coeding.springmvc.dao.BlogPostDao;
import com.coeding.springmvc.config.ApplicationProperty;
import com.coeding.springmvc.utils.DataSourceFactory;
import com.coeding.springmvc.vo.News;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// step 3. spring jdbc - jdbctemplate
	private JdbcTemplate jdbc;
	// step 5. spring+mybatis
	private SqlSession session;
	
	@Autowired
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userName);
		logger.info("Welcome home! The client locale is {}.", ApplicationProperty.userEmail);

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
		return "home";
	}

	
	/**
	 * ????????? 3 ????????? ???????????? @ResponseBody ??? ????????? ????????? JSON ?????? ???????????? ?????? ??????
	 * ????????? ?????? ?????????????????? ResponseEntity ??? ???????????? ????????? ?????? ????????? ??????
	 * 
	 * @return
	 */
	@GetMapping("/news/v1")
	@ResponseBody
	public News news1() {
		return new News("new airport"," international airport closed");
	}

	@GetMapping("/news/v2")
	@ResponseBody
	public ResponseEntity<News> news2() {
		return new ResponseEntity<News>(new News("Worldcup","good fight"), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);		
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		SecurityContextHolder.clearContext();
		if (session != null) {
			session.invalidate();
		}
		return "login";
	}
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) {
		logger.info("Welcome Admin! {}.", locale);		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message", "admin" );
		
		return "home";
	}

}
