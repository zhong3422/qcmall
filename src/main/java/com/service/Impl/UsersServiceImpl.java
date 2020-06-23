package com.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Users;
import com.bean.UsersExample;
import com.dao.UsersMapper;
import com.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersMapper usersMapper;

	@Override
	public List<Users> login(Users users) {
		// TODO Auto-generated method stub
		UsersExample usersExample=new UsersExample();
		usersExample.createCriteria().andUsernameEqualTo(users.getUsername()).andPasswordEqualTo(users.getPassword());
//		usersExample.createCriteria().andPasswordEqualTo(users.getPassword()).an;
		return usersMapper.selectByExample(usersExample);
	}

	@Override
	public boolean register(Users users) {
		// TODO Auto-generated method stub
		if (UsernameDetection(users)) {
			usersMapper.insertSelective(users);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean UsernameDetection(Users users) {
		// TODO Auto-generated method stub
		UsersExample example=new UsersExample();
		example.createCriteria().andUsernameEqualTo(users.getUsername());
		if (usersMapper.selectByExample(example).size()>0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public int updateUsers(Users users) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKeySelective(users);
	}
	
	
}
