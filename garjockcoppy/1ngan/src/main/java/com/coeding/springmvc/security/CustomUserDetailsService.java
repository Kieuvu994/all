//package com.coeding.springmvc.security;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomUserDetailsService implements UserDetailsService{
//	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
//	@Autowired
//	private AuthUserMapper mapper;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		CUser user = mapper.selectOne(username);
//		logger.info("{} ", user.getPassword());
//		return user;
//	}
//
//}
