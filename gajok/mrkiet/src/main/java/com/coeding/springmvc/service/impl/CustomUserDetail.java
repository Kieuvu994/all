package com.coeding.springmvc.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.coeding.springmvc.entity.Userz;

public class CustomUserDetail extends Userz implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8837650140676378162L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorityList = new ArrayList<>();
		super.getRolezs().forEach(role -> {
			authorityList.add(new SimpleGrantedAuthority(role.getName()));
		});
		return authorityList;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	public CustomUserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomUserDetail(Userz user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
