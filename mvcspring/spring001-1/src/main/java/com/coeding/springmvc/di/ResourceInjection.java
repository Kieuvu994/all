package com.coeding.springmvc.di;

import org.springframework.stereotype.Component;

@Component(value = "props")
public class ResourceInjection {
	
	public ResourceInjection() {
		System.out.println(this + " created by name props");
	}

}
