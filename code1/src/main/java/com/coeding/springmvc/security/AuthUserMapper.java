package com.coeding.springmvc.security;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthUserMapper {
	
	CUser selectOne(String username);
}
