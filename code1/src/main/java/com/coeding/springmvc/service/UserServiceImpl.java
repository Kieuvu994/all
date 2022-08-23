package com.coeding.springmvc.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coeding.springmvc.dao.UserDao;
import com.coeding.springmvc.dto.CreateUserDto;
import com.coeding.springmvc.dto.LoginUser;
import com.coeding.springmvc.dto.UserDto;
import com.coeding.springmvc.entity.User;

/**
 * @author: vu find User find key(user name.. create delete update list
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private static String uploadDir = "/WEB-INF/classes/static/images";
	@Autowired
	ServletContext ctx;

	@Override
	public int loginUser(LoginUser lou) {
		System.out.println(lou.getUsername());
		User user = userDao.getUserByUsername(lou.getUsername());

		if (user != null && lou.getPassword().equals(user.getPassword())) {
			return 1;
		} else if (user != null && !lou.getPassword().equals(user.getPassword())) {
			return 2;
		}
		return 0;
	}

	@Override
	public int createUser(CreateUserDto dto)  {

		if (userDao.getUserByUsername(dto.getUsername()) != null || dto.getUsername() == null) {
			return 2;
		} else {
			MultipartFile file = dto.getImage();
			String imgUUID=null;
			if (!file.isEmpty()) {
				imgUUID = file.getOriginalFilename();
				String realPath = ctx.getRealPath(uploadDir);//+uploadDir;
				Path fileNameAndPath = Paths.get(realPath, File.separator+imgUUID);
				System.err.println(fileNameAndPath);
				try {
					Files.write(fileNameAndPath, file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			User user= new User(0, null, dto.getEmail(), dto.getFirstName(),
					dto.getIsActive(), dto.getIsStaff(), dto.getIsSuperuser(),null, dto.getLastName(),
					dto.getPassword(), dto.getUsername(),imgUUID);
			userDao.createUser(user);
			return 1;
		}
	}

	@Override
	public List<UserDto> listUser() {
		List<User> list = userDao.listUser();
		List<UserDto> listdto = new ArrayList<UserDto>();
		if (list != null) {
			for (User lis : list) {
				UserDto user = new UserDto(lis.getId(), lis.getDateJoined(), lis.getEmail(), lis.getFirstName(), lis.getIsActive(),
						lis.getIsStaff(), lis.getIsSuperuser(), lis.getLastLogin(), lis.getLastName(),
						lis.getUsername(),lis.getImage());
				listdto.add(user);
			}
		}
		return listdto;
	}

	@Override
	public int deleteUser(Integer id) {
		User user = userDao.getUserById(id);
		if (user != null) {
			userDao.deleteUser(id);
			
			return 1;
		} else
			return 0;
	}

	@Override
	public int updateUser(UserDto dto) {
		User user = userDao.getUserByUsername(dto.getUsername());
		if (user != null && dto.getUsername().equals(user.getUsername())) {
			User newuser = new User(user.getId(), user.getDateJoined(), dto.getEmail(), dto.getFirstName(),
					dto.getIsActive(), dto.getIsStaff(), dto.getIsSuperuser(), user.getLastLogin(), dto.getLastName(),
					user.getPassword(), user.getUsername(),user.getImage());
			userDao.updateUser(newuser);
			System.out.println(newuser.toString());
			return 1;
		}
		return 0;
	}

	@Override
	public List<UserDto> getUsersWithKey(String key) {
		// TODO Auto-generated method stub
		List<User> list = userDao.getUsersWithKey(key);
		List<UserDto> lists = new ArrayList<UserDto>();
		if (lists != null) {
			for (User lis : list) {
				UserDto user = new UserDto(lis.getId(), lis.getDateJoined(), lis.getEmail(), lis.getFirstName(), lis.getIsActive(),
						lis.getIsStaff(), lis.getIsSuperuser(), lis.getLastLogin(), lis.getLastName(),
						lis.getUsername(),lis.getImage());
				lists.add(user);
			}
		}
		return lists;
	}

	@Override
	public UserDto getUserDtoByUsername(String username) {
		if (username != null && username != "") {
			User lis = userDao.getUserByUsername(username);
			if (lis != null && lis.getUsername() != null) {
				UserDto user = new UserDto(lis.getId(), lis.getDateJoined(), lis.getEmail(), lis.getFirstName(),
						lis.getIsActive(), lis.getIsStaff(), lis.getIsSuperuser(), lis.getLastLogin(),
						lis.getLastName(), lis.getUsername(),lis.getImage());
				return user;
			}
		}
		return null;
	}

	@Override
	public int resetpassword(String username) {
		User lis = userDao.getUserByUsername(username);
		if(lis!=null) {
			int in = userDao.Resetpassword(username);
			System.out.println("reset"+in);
			return in;
		}
		return 0;
	}

	@Override
	public int addUser(UserDto dto) {
		if (userDao.getUserByUsername(dto.getUsername()) != null || dto.getUsername() == null) {
			return 2;
		} else {
			MultipartFile upfile = dto.getImages();
			String filename=null;
			if (!upfile.isEmpty()) {
				filename =dto.getUsername()+".jpg";
				//filename =dto.getId() + upfile.getOriginalFilename();
				//String realPath = ctx.getRealPath(uploadDir);//+uploadDir;
//				Path fileNameAndPath = Paths.get(filename, File.separator+filename);
//				System.err.println(fileNameAndPath);
				
				try {
					File file = new File(filename);
					upfile.transferTo(file);
					//Files.write(fileNameAndPath, file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			User user= new User(0, null, dto.getEmail(), dto.getFirstName(),
					dto.getIsActive(), dto.getIsStaff(), dto.getIsSuperuser(),null, dto.getLastName(),
					"123456", dto.getUsername(),filename);
			userDao.createUser(user);
			return 1;
		}
		
	}

}
