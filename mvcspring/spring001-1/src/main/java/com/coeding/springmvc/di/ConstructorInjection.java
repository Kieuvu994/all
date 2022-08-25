package com.coeding.springmvc.di;

import org.springframework.stereotype.Component;

@Component
public class ConstructorInjection {

	public ConstructorInjection(ParamClass param) {
		System.out.println(this + " created with" + param);
	}
}
