package mrvu.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mrvu.dto.UserDto;
import mrvu.interfaces.UserService;
import mrvu.jpa.User;
@Service
public class UserServiceVu implements UserService {
	private SqlSession session;

	@Autowired
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub\
		User  user = session.selectOne("mrvu.user.getUserById");
		return user;
	}

	@Override
	public List<User> listUser() {
		return session.selectList("mrvu.user.listUser");
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return session.delete("mrvu.user.deleteUser");
	}
	@Override
	public int updateUser(UserDto dto) {
		// TODO Auto-generated method stub
		return session.update("mrvu.user.updateUser", dto);
	}
	@Override
	public int createUser(UserDto dto) {
		// TODO Auto-generated method stub
		return session.insert("mrvu.user.createUser",dto);
	}


}
