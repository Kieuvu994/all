package com.coeding.springmvc;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.coeding.springmvc.di.FieldInjection;
import com.coeding.springmvc.di.ResourceInjection;

@Controller
public class DIController {
	
	//Field 위에 @Autowried 를 붙여 해당 instance 를 spring container 로부터 받는다.
	@Autowired
	private FieldInjection fi;

	@Resource(type = FieldInjection.class)
	private FieldInjection resourcefi;

	@Autowired
	@Qualifier("props")
	private ResourceInjection qualifiedfi;

	@Resource(name = "props")
	private ResourceInjection namedfi;

	@GetMapping("/di")
	protected String testDI() {
		
		System.out.println(fi);
		//	(1) Autowired 붙이기 전 실행 : NullPointerException: Cannot invoke "Object.getClass()" because "this.fi" is null
		//	(2) Autowired 붙인 후 실행 : NoSuchBeanDefinitionException: No qualifying bean of type 'com.coeding.springmvc.di.FieldInjection'
		//		- FieldInjection 가 Spring Container 에 bean 이라고 등록 되어 있지 않다.

		//	(3) javax.annotation 의 @Resource(type) 사용
		System.out.println(resourcefi);
		
		//	(4) @Autowired @Qualifier("name") 사용
		System.out.println(qualifiedfi);

		//	(5) javax.annotation 의 @Resource("name") 사용
		System.out.println(namedfi);

		return "home";
	}

}

/*
 *	@Autowired는 단독으로 사용 가능
 *		단독으로 사용하면 Type 기준(Class Name). 
 *		따라서 동일한 Type 의 bean 이 두 개 이상 선언되면 문제가 발생
 *		@Qualifier를 @Autowired 와 함께 사용하여 bean 의 이름(id)을 지정
 *			@Autowired
 *			@Qualifier("alpha")
 *
 *	import javax.annotation.Resource;
 *	@Resource(name="alpha")
 *		@Resource도 이름으로 연결. 
 *		따라서 @Autowired를 @Qualifier와 함께 사용하면 @Resource와 동일
 *
 *	차이점은 @Autowired 및 @Qualifier는 Spring 의 annotation이고 
 * 	@Resource는 표준 Java 주석(JSR-250에서)
 *  @Resource는 field 및 setter(설정자) 주입만 지원
 *  @Autowired는 field, setter, constructor 및 다중 인수 메서드 주입(v5+)을 지원
 *  
 *  권장
 *  	field 및 setter 주입에서는 @Resource를 사용. 
 *  	contructor 또는 다중 인수 메소드 주입을 위해 @Qualifier 및 @Autowired를 권장
 *  
 *  	annotation 기반 주입을 이름으로 표현하려는 경우 
 *  		기술적으로 @Qualifier 값을 통해 bean 이름을 참조할 수 있는 경우에도 @Autowired 를 주로 사용하지 마십시오. 
 *  		대신 정의된 고유한 이름으로 특정 대상 구성요소를 식별하도록 의미론적으로 정의된 JSR-250 @Resource 주석을 선호
 *  
 */
