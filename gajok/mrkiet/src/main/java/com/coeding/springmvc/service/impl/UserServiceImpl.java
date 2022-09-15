package com.coeding.springmvc.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coeding.springmvc.entity.Rolez;
import com.coeding.springmvc.entity.Userz;
import com.coeding.springmvc.repository.RoleRepository;
import com.coeding.springmvc.repository.UserRepository;
import com.coeding.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder encoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
	}

	@Override
	public Userz findById(int id) {
		// TODO Auto-generated method stub
		return this.userRepository.findById(id);
	}

	@Override
	public List<Userz> findAll() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public String create(Userz pojo) {
		// TODO Auto-generated method stub
		Userz t = new Userz();
		t.setDateJoined(new Timestamp(System.currentTimeMillis()));
		t.setEmail(pojo.getEmail());
		t.setFirstName(pojo.getFirstName());
		t.setIsActive(Byte.valueOf("0"));
		t.setIsStaff(Byte.valueOf("0"));
		t.setIsSuperuser(Byte.valueOf("0"));
		t.setLastName(pojo.getLastName());
		t.setUsername(pojo.getUsername());
		t.setPassword(encoder.encode(pojo.getPassword()));
		t.setRole("USER");
		
		Rolez customerRole = roleRepository.findByRole("ADMIN");
		if(customerRole == null) {
			customerRole = new Rolez();
			customerRole.setName("USER");
		}
		roleRepository.create(customerRole);
		
		t.setRolezs(new ArrayList<Rolez>(Arrays.asList(customerRole)));
		
		return this.userRepository.create(t);
	}

	@Override
	public String update(Userz pojo) {
		// TODO Auto-generated method stub
		return this.userRepository.update(pojo);
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return this.userRepository.delete(id);
	}

	@Override
	public Userz findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return this.userRepository.findUserByEmail(email);
	}

	@Override
	public Userz findByUsername(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Userz customer = userRepository.findByUsername(username);
		if(customer == null) {
			throw new UsernameNotFoundException("Invalid details");
		}
		List<GrantedAuthority> authorities = getCustomerAutority((Set<Rolez>) customer.getRolezs());
		return buildUserForAuthentication(customer, authorities);
	}
	private List<GrantedAuthority> getCustomerAutority(Set<Rolez> role) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for(Rolez currRole : role) {
			roles.add(new SimpleGrantedAuthority(currRole.getName()));
		}
		List<GrantedAuthority> grandAuthorities = new ArrayList<>(roles);
		return grandAuthorities;
	}
	
	private UserDetails buildUserForAuthentication(Userz customer, List<GrantedAuthority> authorities) {
		return new User(customer.getEmail(), customer.getPassword(),true, true, true, true, authorities);
	}

}
