package com.coeding.springmvc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Deprecated
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/size")
public class RestSize {
//	
//	private SizeService service;
//	{
//		service = new SizeServiceVu01();
//	}
//	
//	@GetMapping("/list")
//	public List<Size> listSize() {
//		return service.list();
//	}
//	@PostMapping("/add")
//	public String addSize(SizeDto dto, Model model) {
//		
//		return service.add(dto);
//	}
//	@PostMapping("/update")
//	public String editSize(SizeDto dto, Model model) {
//		
//		return service.update(dto);
//	}
//	@GetMapping("/delete/{id}")
//	public String deleteSize(@PathVariable("id") Integer id) {
//		
//		return service.delete();
//	}
}
