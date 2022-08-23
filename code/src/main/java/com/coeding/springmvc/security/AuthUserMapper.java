package com.coeding.springmvc.security;

import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserMapper {
	CUser selectOne(String username);
}
