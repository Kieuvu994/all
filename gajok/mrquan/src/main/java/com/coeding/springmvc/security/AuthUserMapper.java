package com.coeding.springmvc.security;


public interface AuthUserMapper {
	CUser selectOne(String username);
}
