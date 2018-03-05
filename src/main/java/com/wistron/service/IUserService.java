package com.wistron.service;

import com.wistron.domain.User;
import com.wistron.exception.UserExistException;

public interface IUserService {
	/**
	 * 鎻愪緵娉ㄥ唽鏈嶅姟
	 * @param user
	 * @throws UserExistException
	 */
	void registerUser(User user) throws UserExistException;

	/**
	 * 鎻愪緵鐧诲綍鏈嶅姟
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	User loginUser(String userName, String userPwd);

}
