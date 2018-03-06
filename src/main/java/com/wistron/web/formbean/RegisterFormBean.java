package com.wistron.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterFormBean {
	
	//RegisterFormBean
		//<input type="text" name="userName"/>
		private String userName;
		//<input type="password" name="userPwd"/>
		private String userPwd;
		//<input type="password" name="confirmPwd"/>
		private String confirmPwd;
		//<input type="text" name="email"/>
		private String email;
		//<input type="text" name="birthday"/>
		private String birthday;

		
		/**
		 * 
		 */
		private Map<String, String> errors = new HashMap<String, String>();

		public Map<String, String> getErrors() {
			return errors;
		}

		public void setErrors(Map<String, String> errors) {
			this.errors = errors;
		}

		/*
		 * validate
		 * 		private String userName; 
		 * 		private String userPwd; 
		 * 		private String confirmPwd;
		 * 		private String email;  
		 * 		private String birthday;
		 */
		public boolean validate() {

			boolean isOk = true;

			if (this.userName == null || this.userName.trim().equals("")) {
				isOk = false;
				errors.put("userName", "Please Check the name");
			} else {
				if (!this.userName.matches("[a-zA-Z]{3,8}")) {
					isOk = false;
					errors.put("userName", "Please Check the name");
				}
			}

			if (this.userPwd == null || this.userPwd.trim().equals("")) {
				isOk = false;
				errors.put("userPwd", "Please Check the Password");
			} else {
				if (!this.userPwd.matches("\\d{3,8}")) {
					isOk = false;
					errors.put("userPwd", "Please Check the Password");
				}
			}

			// private String password2; 涓ゆ瀵嗙爜瑕佷竴鑷�
			if (this.confirmPwd != null) {
				if (!this.confirmPwd.equals(this.userPwd)) {
					isOk = false;
					errors.put("confirmPwd", "Please Check the ComPassword");
				}
			}

			// private String email; 
			if (this.email != null && !this.email.trim().equals("")) {
				if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
					isOk = false;
					errors.put("email", "The Format of E-Mail is wrong.");
				}
			}

			
			if (this.birthday != null && !this.birthday.trim().equals("")) {
				try {
					DateLocaleConverter conver = new DateLocaleConverter();
					conver.convert(this.birthday);
				} catch (Exception e) {
					isOk = false;
					errors.put("birthday", "the format is wrong");
				}
			}

			return isOk;
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

		public String getConfirmPwd() {
			return confirmPwd;
		}

		public void setConfirmPwd(String confirmPwd) {
			this.confirmPwd = confirmPwd;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
	

}
