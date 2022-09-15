package com.coeding.springmvc.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coeding.springmvc.dto.UserDto;
import com.coeding.springmvc.entity.User;
import com.coeding.springmvc.service.UserService;

/**
 * 
 * @author Quan
 *
 */

@Service
public class UserServiceImpl implements UserService {
	
	private SqlSessionFactory sessionFac;
	
	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println("1. get SessionFactory for session : "+sessionFac);
		this.sessionFac = sessionFac;
	}

	@Override
	public User getUserById(Integer id) {
		SqlSession session = sessionFac.openSession();
		User  user = session.selectOne("mrvu.user.getUserById");
		session.close();
		return user;
	}

	@Override
	public List<User> listUser() {
		SqlSession session = sessionFac.openSession();
		List<User>  list = session.selectList("mrvu.user.listUser");
		session.close();
		return list;
	}

	@Override
	public int deleteUser(Integer id) {
		SqlSession session = sessionFac.openSession();
		int in = session.delete("mrvu.user.deleteUser");
		session.commit();
		session.close();
		return in;	
		
	}
	@Override
	public int updateUser(UserDto dto) {
		SqlSession session = sessionFac.openSession();
		int in = session.update("mrvu.user.updateUser", dto);
		session.commit();
		session.close();
		return in;	
	}
	@Override
	public int createUser(UserDto dto) {
		SqlSession session = sessionFac.openSession();
		int in = session.insert("mrvu.user.createUser",dto);
		session.commit();
		session.close();
		return in;
		
	}

	/**
	 * @return non-null UserDto
	 */
	@Override
	public UserDto getUser(String username) {
		System.out.println("1. check argument to get from table");
		if( username != null && !username.isEmpty()) {
			System.out.println("2. open session from factory");
			SqlSession session = sessionFac.openSession();
			System.out.println("3. select user from table userz");
			User user = session.selectOne("mrvu.user.getUserByUserName",username);
			session.close();
			if( user != null ) {
				System.out.println("4. return as UserDto");
				return new UserDto(user);
			}
		}
		return new UserDto();
	}


}
