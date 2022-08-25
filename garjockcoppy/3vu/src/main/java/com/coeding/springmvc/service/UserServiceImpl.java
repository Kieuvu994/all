package com.coeding.springmvc.service;

import java.io.File;
import java.io.IOException;
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
import com.coeding.springmvc.entitys.Userz;

/**
 * @author: vu find User find key(user name.. create delete update list
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private static String uploadDir = "D:/images/";
	@Autowired
	ServletContext ctx;

	@Override
	public int loginUser(LoginUser lou) {
		System.out.println(lou.getUsername());
		Userz user = userDao.getUserByUsername(lou.getUsername());

		if (user != null && lou.getPassword().equals(user.getPassword())) {
			return 1;
		} else if (user != null && !lou.getPassword().equals(user.getPassword())) {
			return 2;
		}
		return 0;
	}

	@Override
	public int createUser(CreateUserDto dto) {

		if (userDao.getUserByUsername(dto.getUsername()) != null || dto.getUsername() == null) {
			return 2;
		} else {
			MultipartFile upfile = dto.getImages();
			String filename = null;
			if (!upfile.isEmpty()) {
				filename = dto.getUsername() + upfile.getOriginalFilename();
				// filename =dto.getId() + upfile.getOriginalFilename();
				// String realPath = ctx.getRealPath(uploadDir);//+uploadDir;
//				Path fileNameAndPath = Paths.get(filename, File.separator+filename);
//				System.err.println(fileNameAndPath);

				try {
					File file = new File(uploadDir + filename);
					System.out.println("save-file: "+file.getPath());
					upfile.transferTo(file);
					// Files.write(fileNameAndPath, file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			Userz user = new Userz(0, null, dto.getEmail(), dto.getFirstName(), filename, (byte)1,
					(byte)0, (byte)0, null, dto.getLastName(), dto.getPassword(),
					dto.getUsername());
			userDao.createUser(user);
			return 1;
		}
	}

	@Override
	public List<UserDto> listUser() {
		List<Userz> list = userDao.listUser();
		List<UserDto> listdto = new ArrayList<UserDto>();
		if (list != null) {
			for (Userz lis : list) {
				UserDto user = new UserDto(lis.getId(), lis.getDateJoined(), lis.getEmail(), lis.getFirstName(),
						lis.getIsActive(), lis.getIsStaff(), lis.getIsSuperuser(), lis.getLastLogin(),
						lis.getLastName(), lis.getUsername(), lis.getImage());
				listdto.add(user);
			}
		}
		return listdto;
	}

	@Override
	public int deleteUser(Integer id) {
		Userz user = userDao.getUserById(id);
		if (user != null) {

			if (user.getImage() != null) {
				try {
					File old = new File(uploadDir + user.getImage());
					old.delete();
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
			userDao.deleteUser(id);
			return 1;
		} else
			return 0;
	}

	@Override
	public int updateUser(UserDto dto) {
		Userz user = userDao.getUserByUsername(dto.getUsername());
		if (user != null && dto.getUsername().equals(user.getUsername())) {
			String filename = user.getImage();
			if (dto.getImages() != null) {
				MultipartFile upfile = dto.getImages();
				if (!upfile.isEmpty()) {

					// filename =dto.getId() + upfile.getOriginalFilename();
					// String realPath = ctx.getRealPath(uploadDir);//+uploadDir;
//					Path fileNameAndPath = Paths.get(filename, File.separator+filename);
//					System.err.println(fileNameAndPath);

					try {
						
						/*
						 * if (user.getImage() != null) { File old = new File(uploadDir +
						 * user.getImage()); old.delete(); }
						 */
						filename = dto.getUsername() + upfile.getOriginalFilename();
						File file = new File(uploadDir + filename);
						System.out.println("save-file: "+file.getPath());
						upfile.transferTo(file);
						// Files.write(fileNameAndPath, file.getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			Userz newuser = new Userz(user.getId(), user.getDateJoined(), dto.getEmail(), dto.getFirstName(), filename,
					dto.getIsActive(), dto.getIsStaff(), dto.getIsSuperuser(), user.getLastLogin(), dto.getLastName(),
					user.getPassword(), user.getUsername());
			userDao.updateUser(newuser);
			System.out.println(newuser.toString());
			return 1;
		}
		return 0;
	}

	@Override
	public List<UserDto> getUsersWithKey(String key) {
		// TODO Auto-generated method stub
		List<Userz> list = userDao.getUsersWithKey(key);
		List<UserDto> lists = new ArrayList<UserDto>();
		if (lists != null) {
			for (Userz lis : list) {
				UserDto user = new UserDto(lis.getId(), lis.getDateJoined(), lis.getEmail(), lis.getFirstName(),
						lis.getIsActive(), lis.getIsStaff(), lis.getIsSuperuser(), lis.getLastLogin(),
						lis.getLastName(), lis.getUsername(), lis.getImage());
				lists.add(user);
			}
		}
		return lists;
	}

	@Override
	public UserDto getUserDtoByUsername(String username) {
		if (username != null && username != "") {
			Userz lis = userDao.getUserByUsername(username);
			if (lis != null && lis.getUsername() != null) {
				UserDto user = new UserDto(lis.getId(), lis.getDateJoined(), lis.getEmail(), lis.getFirstName(),
						lis.getIsActive(), lis.getIsStaff(), lis.getIsSuperuser(), lis.getLastLogin(),
						lis.getLastName(), lis.getUsername(), lis.getImage());
				return user;
			}
		}
		return null;
	}

	@Override
	public int resetpassword(String username) {
		Userz lis = userDao.getUserByUsername(username);
		if (lis != null) {
			int in = userDao.Resetpassword(username);
			System.out.println("reset" + in);
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
			String filename = null;
			if (!upfile.isEmpty()) {
				filename = dto.getUsername() + upfile.getOriginalFilename();
				// filename =dto.getId() + upfile.getOriginalFilename();
				// String realPath = ctx.getRealPath(uploadDir);//+uploadDir;
//				Path fileNameAndPath = Paths.get(filename, File.separator+filename);
//				System.err.println(fileNameAndPath);

				try {
					File file = new File(uploadDir + filename);
					upfile.transferTo(file);
					System.out.println("save-file: "+file.getPath());
					// Files.write(fileNameAndPath, file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			Userz user = new Userz(0, null, dto.getEmail(), dto.getFirstName(), filename, dto.getIsActive(),
					dto.getIsStaff(), dto.getIsSuperuser(), null, dto.getLastName(), "123456", dto.getUsername());
			userDao.createUser(user);
			return 1;
		}

	}

	@Override
	public int changePW(LoginUser user) {
		int in = userDao.changePW(user);
		return 0;
	}

}
