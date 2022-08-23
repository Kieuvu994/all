package com.coeding.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.entity.User;
/**
 * @author vu
 *
 * */

@Repository
public class UserDao {
	private SqlSessionFactory sessionFac;
	
	//@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}

	public User getUserById(Integer id) {
		SqlSession session = sessionFac.openSession();
		User user = session.selectOne("mrvu.user.getUserById",id);
		System.out.println(user+"-----------");
		session.close();
		return user;
	}
	public User getUserByUsername(String username) {
		SqlSession session = sessionFac.openSession();
		User user = session.selectOne("mrvu.user.getUserByUsername",username);
		System.out.println(user+"-----------");
		session.close();
		return user;
	}
	
	public List<User> listUser() {
		SqlSession session = sessionFac.openSession();
		List<User>  list = session.selectList("mrvu.user.listUser");
		session.close();
		return list;
	}

	public int deleteUser(Integer id) {
		SqlSession session = sessionFac.openSession();
		int in = session.delete("mrvu.user.deleteUser",id);
		session.commit();
		session.close();
		return in;	
		
	}
	public int updateUser(User user) {
		SqlSession session = sessionFac.openSession();
		int in = session.update("mrvu.user.updateUser", user);
		session.commit();
		session.close();
		return in;	
	}
	public int createUser(User dto) {
		SqlSession session = sessionFac.openSession();
		int in = session.insert("mrvu.user.createUser",dto);
		session.commit();
		session.close();
		return in;
		
	}

	public List<User> getUsersWithKey(String key) {
		SqlSession session = sessionFac.openSession();
		List<User> users = session.selectList("mrvu.user.getUsersWithKey",key);
		System.out.println(users+"-----------");
		session.close();
		// TODO Auto-generated method stub
		return users;
	}

	public int Resetpassword(String username) {
		SqlSession session = sessionFac.openSession();
		int in = session.update("mrvu.user.resetpassword", username);
		session.commit();
		session.close();
		return in;	
	}


}
