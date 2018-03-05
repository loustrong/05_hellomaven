package com.wistron.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gacl
 * 鐢ㄦ埛瀹炰綋绫�
 */
public class User implements Serializable {

	private static final long serialVersionUID = -4313782718477229465L;
	
	// 鐢ㄦ埛ID
	private String id;
	// 鐢ㄦ埛鍚�
	private String userName;
	// 鐢ㄦ埛瀵嗙爜
	private String userPwd;
	// 鐢ㄦ埛閭
	private String email;
	// 鐢ㄦ埛鐢熸棩
	private Date birthday;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}