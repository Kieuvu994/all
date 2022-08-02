package vu.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vu.dto.Cart;

@RestController
@RequestMapping("/api")
public class MainRestController {
	
	@RequestMapping("/v1/cart/list")
	public List<Cart> listCart(){
		return (new ArrayList<Cart>());
	}
	
	@PostMapping("/file/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file);
		return "{'status':'ok'}";
	}

}
