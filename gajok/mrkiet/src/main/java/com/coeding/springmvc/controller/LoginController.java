package com.coeding.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coeding.springmvc.entity.Userz;
import com.coeding.springmvc.service.UserService;

@Controller
public class LoginController {

	private static String authorizationRequestBaseUri = "oauth2/authorization";
	Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/login")
	public String login(Model model) {
		Iterable<ClientRegistration> clientRegistrations = null;
		ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository).as(Iterable.class);
		if (type != ResolvableType.NONE && ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
			clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
		}

		clientRegistrations.forEach(registration -> oauth2AuthenticationUrls.put(registration.getClientName(),
				authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
		model.addAttribute("urls", oauth2AuthenticationUrls);

		Userz customer = new Userz();
		model.addAttribute("customerObj", customer);
		return "login";
	}

	@GetMapping(value = "/showCustomerForm")
	public String showCustomerForm(Model model) {
		Userz customer = new Userz();
		model.addAttribute("customerObj", customer);
		return "register";
	}

	@PostMapping(value = "/register")
	public ModelAndView saveCustomer(@ModelAttribute("customerObj") @Valid Userz customer,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		Userz customerTemp = userService.findUserByEmail(customer.getEmail());
		if (customerTemp != null) {
			bindingResult.rejectValue("email", "There is already an account with this email");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
			return modelAndView;
		}
		userService.create(customer);
		modelAndView.addObject("successMessage", "Customer has been registered successfully");
		modelAndView.setViewName("redirect:/shop-grid");
		return modelAndView;
	}
}
