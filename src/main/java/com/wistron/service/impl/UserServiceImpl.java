package com.wistron.service.impl;

import com.wistron.dao.IUserDao;
import com.wistron.dao.impl.UserDaoImpl;
import com.wistron.domain.User;
import com.wistron.exception.UserExistException;
import com.wistron.service.IUserService;



public class UserServiceImpl implements IUserService{
private IUserDao userDao = new UserDaoImpl();
@Override
	public void registerUser(User user) throws UserExistException {
		if (userDao.find(user.getUserName())!=null) {
			//checked exception 
			//unchecked exception
			//
			throw new UserExistException("Exception,UserServiceImpl");
		}
		userDao.add(user);
	}
@Override
	public User loginUser(String userName, String userPwd) {
		return userDao.find(userName, userPwd);
	}

}
