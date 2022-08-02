package vu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vu.dto.Size;

@RestController
public class Restcontroller {
 
	@GetMapping("/rest")
	public List<Size> rest(){
		Size size = new Size(2,BigDecimal.valueOf(250,000),"/Rest");
		List<Size> list = new ArrayList<Size>();
		list.add(size);
		return list;
	}
}
