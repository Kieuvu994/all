package com.coeding.springmvc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coeding.springmvc.dto.LoginUser;
import com.coeding.springmvc.entitys.Userz;
/**
 * @author vu
 *
 * */

@Repository
public class UserDao {
	private SqlSessionFactory sessionFac;
	
	@Autowired
	public void setSessionFac(SqlSessionFactory sessionFac) {
		System.out.println(sessionFac);
		this.sessionFac = sessionFac;
	}

	public Userz getUserById(Integer id) {
		SqlSession session = sessionFac.openSession();
		Userz user = session.selectOne("mrvu.user.getUserById",id);
		System.out.println(user+"-----------");
		session.close();
		return user;
	}
	public Userz getUserByUsername(String username) {
		SqlSession session = sessionFac.openSession();
		Userz user = session.selectOne("mrvu.user.getUserByUsername",username);
		System.out.println(user+"-----------");
		session.close();
		return user;
	}
	
	public List<Userz> listUser() {
		SqlSession session = sessionFac.openSession();
		List<Userz>  list = session.selectList("mrvu.user.listUser");
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
	public int updateUser(Userz user) {
		SqlSession session = sessionFac.openSession();
		int in = session.update("mrvu.user.updateUser", user);
		session.commit();
		session.close();
		return in;	
	}
	public int createUser(Userz dto) {
		SqlSession session = sessionFac.openSession();
		int in = session.insert("mrvu.user.createUser",dto);
		session.commit();
		session.close();
		return in;
		
	}

	public List<Userz> getUsersWithKey(String key) {
		SqlSession session = sessionFac.openSession();
		List<Userz> users = session.selectList("mrvu.user.getUsersWithKey",key);
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

	public int changePW(LoginUser user) {
		SqlSession session = sessionFac.openSession();
		int in = session.update("mrvu.user.changePW", user);
		session.commit();
		session.close();
		return in;
	}


}
