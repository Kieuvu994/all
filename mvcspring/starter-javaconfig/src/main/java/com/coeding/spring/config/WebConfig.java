package com.coeding.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.coeding.spring.filter.DemoFilter;
import com.coeding.spring.listener.DemoListener;
import com.coeding.spring.servlet.DemoServlet;

public class WebConfig implements WebApplicationInitializer{

//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO: Java based
//		// Create the 'root' Spring application context
//		//	/WEB-INF/spring/root-context.xml
//		AnnotationConfigWebApplicationContext rootContext =
//				new AnnotationConfigWebApplicationContext();
//		rootContext.register(AppConfig.class);
//
//		// Manage the lifecycle of the root application context
//		servletContext.addListener(new ContextLoaderListener(rootContext));
//
//		// Create the dispatcher servlet's Spring application context
//		//	/WEB-INF/spring/appServlet/servlet-context.xml
//		AnnotationConfigWebApplicationContext dispatcherContext =
//				new AnnotationConfigWebApplicationContext();
//		dispatcherContext.register(DispatcherConfig.class);
//
//		// Register and map the dispatcher servlet
//		ServletRegistration.Dynamic dispatcher =
//				servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//
//	}
	
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// TODO: XML based
//		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
//		appContext.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
//		ServletRegistration.Dynamic dispatcher =
//				servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic demoServlet =
				servletContext.addServlet("demoServlet", DemoServlet.class);
		demoServlet.addMapping("/demo");
		demoServlet.addMapping("/demo/");
		// Register Listener
		servletContext.addListener(DemoListener.class);
		// Register Filter
		servletContext.addFilter("demoFilter", DemoFilter.class)
			.addMappingForUrlPatterns(null, false, "/demo/*");
	}

}
