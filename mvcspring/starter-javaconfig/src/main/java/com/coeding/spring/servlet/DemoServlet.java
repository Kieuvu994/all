package com.coeding.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Servlet 단위로 URL mapping
 * 
 * @author coeding
 *
 */
//@WebServlet(urlPatterns= {"/demo","/demo/"}, name="demoServlet")
public class DemoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = resp.getWriter();
        out.println("DemoServlet:doGet -> ");
//		super.doGet(req, resp);
	}

	
}
