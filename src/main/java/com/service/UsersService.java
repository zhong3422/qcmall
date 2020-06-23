package com.service;

import java.util.List;

import com.bean.Users;

public interface UsersService {

	List<Users> login(Users users);

	boolean register(Users users);

	boolean UsernameDetection(Users users);

	int updateUsers(Users users);

	
	
}
