//package com.coeding.springmvc.security;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomAuthenticationProvider implements AuthenticationProvider{
//	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
//	private CustomUserDetailsService customUserDetailsService;
//
//	@Autowired
//	public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
//		this.customUserDetailsService = customUserDetailsService;
//	}
//	
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication; 
//		UserDetails userInfo = customUserDetailsService.loadUserByUsername(authToken.getName()); 
////		logger.info("{}{}", authToken.getName(), authToken.getCredentials());
//
//		if (userInfo == null) {
//			throw new UsernameNotFoundException(authToken.getName());
//		}
//		if (!(userInfo.getPassword().equals(authToken.getCredentials()))) {  
//			throw new BadCredentialsException("not matching username or password");
//		}
//		List<GrantedAuthority> authorities = null;
//		if( userInfo instanceof CUser) {
//			CUser user = (CUser)userInfo;
//			authorities = (List<GrantedAuthority>) user.getAuthorities(); 			
//		}else {
//			authorities = (List<GrantedAuthority>) userInfo.getAuthorities(); 
//		}
//
//		return new UsernamePasswordAuthenticationToken(userInfo,null,authorities);
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
//
//}
