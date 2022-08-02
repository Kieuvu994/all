package mrvu.interfaces;

import java.util.List;

import mrvu.dto.UserDto;
import mrvu.jpa.User;

public interface UserService {

	User getUserById(Integer id);

	List<User> listUser();

	int deleteUser(Integer id);

	int updateUser(UserDto dto);
	
	int createUser(UserDto dto);

}
