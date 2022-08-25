package com.coeding.springmvc.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterInjection {

	private FieldClass fc;
	
	public SetterInjection(ParamClass param) {
		System.out.println(this + " created with " + param);
	}
	
	@Autowired
	public void setFieldClass(FieldClass arg) {
		this.fc = arg;
		System.out.println(this + " setted with " + arg);
		
	}
}
