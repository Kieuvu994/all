package com.coeding.springmvc.security;

//@Deprecated
public interface AuthUserMapper {
	CUser selectOne(String username);
}
