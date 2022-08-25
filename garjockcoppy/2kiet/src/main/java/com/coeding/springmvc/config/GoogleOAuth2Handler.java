package com.coeding.springmvc.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.coeding.springmvc.entity.Rolez;
import com.coeding.springmvc.entity.Userz;
import com.coeding.springmvc.repository.RoleRepository;
import com.coeding.springmvc.repository.UserRepository;

//not used yet
@Component
public class GoogleOAuth2Handler implements AuthenticationSuccessHandler{

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
		String username = token.getPrincipal().getAttributes().get("username").toString();
		if (userRepository.findByUsername(username) == null) {
			
		} else {
			Userz user = new Userz();
			user.setFirstName(token.getPrincipal().getAttributes().get("first_name").toString());
			user.setLastName(token.getPrincipal().getAttributes().get("last_name").toString());
			user.setEmail(token.getPrincipal().getAttributes().get("email").toString());
			user.setUsername(username);
			
			List<Rolez> roles = new ArrayList<>();
			roles.add(roleRepository.findById(2));
			user.setRolezs(roles);
			userRepository.create(user);
		}
		redirectStrategy.sendRedirect(request, response, "/");
	}

}
