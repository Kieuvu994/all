package vu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("list", "homepage");
		return "home";// viewResolver -> home file -> data binding -> html -> response
	}
	
	@GetMapping("/file")
	public String fileForm() {
		return "fileform";
	}

}
