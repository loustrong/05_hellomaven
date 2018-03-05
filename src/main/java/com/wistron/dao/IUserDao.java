package com.wistron.dao;

import com.wistron.domain.User;

public interface IUserDao {
	
	/**
	 * 鏍规嵁鐢ㄦ埛鍚嶅拰瀵嗙爜鏉ユ煡鎵剧敤鎴�
	 * @param userName
	 * @param userPwd
	 * @return 鏌ュ埌鍒扮殑鐢ㄦ埛
	 */
	User find(String userName, String userPwd);

	/**
	 * 娣诲姞鐢ㄦ埛
	 * @param user
	 */
	void add(User user);

	/**鏍规嵁鐢ㄦ埛鍚嶆潵鏌ユ壘鐢ㄦ埛
	 * @param userName
	 * @return 鏌ュ埌鍒扮殑鐢ㄦ埛
	 */
	User find(String userName);

}
