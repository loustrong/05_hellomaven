package com.wistron.service;

import com.wistron.domain.User;
import com.wistron.exception.UserExistException;

public interface IUserService {
	/**
	 * 
	 * @param user
	 * @throws UserExistException
	 */
	void registerUser(User user) throws UserExistException;

	/**
	 * 
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	User loginUser(String userName, String userPwd);

}
