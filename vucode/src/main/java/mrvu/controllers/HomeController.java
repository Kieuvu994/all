package mrvu.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mrvu.jpa.Size;

@Controller
public class HomeController<E> {
	//@ResponseBody
	@GetMapping("/home")
	public String home(Model model) {
		Size size =new Size();
		size.setId(0); size.setSize("home"); size.setPrice(new BigDecimal(10000));
		List<Size> list =new ArrayList<Size>();
		list.add(size);
	//	System.out.println(teams);
		model.addAttribute("list",list.toString());

		return "home";
	}




}
