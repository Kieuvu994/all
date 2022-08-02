package vu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import vu.dto.Size;

@Controller
public class Sizecontroller {
	@GetMapping("/size")
	public String size(Model model) {

		Size size = new Size(1,BigDecimal.valueOf(15.000) ,"/Size");
	
		List<Size> list = new ArrayList<Size>();
		list.add(size);
		System.out.println(size.getPrice());
		System.out.println(list.toString());
		model.addAttribute("list",list.toString());
		
		return "home";
	}

	@GetMapping("/news")
	@ResponseBody
	public List<Size> news1() {
		Size size = new Size(1,BigDecimal.valueOf(15.000) ,"new");
		
		List<Size> list = new ArrayList<Size>();
		list.add(size);
		return list;
	}

}
