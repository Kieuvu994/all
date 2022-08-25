package com.coeding.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class AppInitializr implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO: web.xml 의 context-param 값 읽어오기
		String location = servletContext.getInitParameter("contextConfigLocation");

		// directory path 출력하기
		System.out.println("contextPath -> "+ servletContext.getContextPath());
		System.out.println("realContextPath -> "+ servletContext.getRealPath(""));
		System.out.println(location);
		
	}

}
