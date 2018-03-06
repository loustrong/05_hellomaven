package com.wistron.dao;

import com.wistron.domain.User;

public interface IUserDao {
	
	/**
	 * 
	 * @param userName
	 * @param userPwd
	 * @return 
	 */
	User find(String userName, String userPwd);

	/**
	 *
	 * @param user
	 */
	void add(User user);

	/**
	 * @param userName
	 * @return 
	 */
	User find(String userName);

}
