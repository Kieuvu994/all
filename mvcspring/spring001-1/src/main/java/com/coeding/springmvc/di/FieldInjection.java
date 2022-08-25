package com.coeding.springmvc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Spring Container 에 bean 으로 등록되는 class 
//	1. xml 설정 file 에 <bean id="" class=""/> 로 등록
//	2. @Component 와 그 하위 annotation 으로 등록
@Component
public class FieldInjection {
	
	@Autowired
	private ConstructorInjection ci;

	public FieldInjection() {
		System.out.println(this + " created ");
//		INFO : org.springframework.web.servlet.DispatcherServlet - Initializing Servlet 'appServlet'
//		com.coeding.springmvc.di.FieldInjection@698ac187 created <-- App 초기화 단계에서 생성된다.
//		INFO : org.springframework.web.servlet.DispatcherServlet - Completed initialization in 1084 ms		
	}
}
