package com.coeding.springmvc.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	// step 3. spring jdbc - jdbctemplate
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		// DB connection
		// step 3. Spring JDBC bean 등록 후 injection 으로 JdbcTemplate 사용
		logger.info("{}", jdbc);
		try {
			jdbc.query("select * from blog_post", new RowMapper() {
	
				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}
				
			});
		}catch(Exception e) {
			logger.info("check your db running");			
		}
		// step 4. mybatis
//		BlogPostDao dao = new BlogPostDao();
		// step 5. spring+mybatis
//		BlogPostRepository dao = new BlogPostRepository();
//		logger.info("{}", dao);
		
		return "home";
	}
	
}
