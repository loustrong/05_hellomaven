package com.wistron.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterFormBean {
	
	//RegisterFormBean涓殑灞炴�т笌register.jsp涓殑琛ㄥ崟杈撳叆椤圭殑name涓�涓�瀵瑰簲
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
		 * 瀛樺偍鏍￠獙涓嶉�氳繃鏃剁粰鐢ㄦ埛鐨勯敊璇彁绀轰俊鎭�
		 */
		private Map<String, String> errors = new HashMap<String, String>();

		public Map<String, String> getErrors() {
			return errors;
		}

		public void setErrors(Map<String, String> errors) {
			this.errors = errors;
		}

		/*
		 * validate鏂规硶璐熻矗鏍￠獙琛ㄥ崟杈撳叆椤�
		 * 琛ㄥ崟杈撳叆椤规牎楠岃鍒欙細
		 * 		private String userName; 鐢ㄦ埛鍚嶄笉鑳戒负绌猴紝骞朵笖瑕佹槸3-8鐨勫瓧姣� abcdABcd 
		 * 		private String userPwd; 瀵嗙爜涓嶈兘涓虹┖锛屽苟涓旇鏄�3-8鐨勬暟瀛�
		 * 		private String confirmPwd; 涓ゆ瀵嗙爜瑕佷竴鑷�
		 * 		private String email; 鍙互涓虹┖锛屼笉涓虹┖瑕佹槸涓�涓悎娉曠殑閭 
		 * 		private String birthday; 鍙互涓虹┖锛屼笉涓虹┖鏃讹紝瑕佹槸涓�涓悎娉曠殑鏃ユ湡
		 */
		public boolean validate() {

			boolean isOk = true;

			if (this.userName == null || this.userName.trim().equals("")) {
				isOk = false;
				errors.put("userName", "鐢ㄦ埛鍚嶄笉鑳戒负绌猴紒锛�");
			} else {
				if (!this.userName.matches("[a-zA-Z]{3,8}")) {
					isOk = false;
					errors.put("userName", "鐢ㄦ埛鍚嶅繀椤绘槸3-8浣嶇殑瀛楁瘝锛侊紒");
				}
			}

			if (this.userPwd == null || this.userPwd.trim().equals("")) {
				isOk = false;
				errors.put("userPwd", "瀵嗙爜涓嶈兘涓虹┖锛侊紒");
			} else {
				if (!this.userPwd.matches("\\d{3,8}")) {
					isOk = false;
					errors.put("userPwd", "瀵嗙爜蹇呴』鏄�3-8浣嶇殑鏁板瓧锛侊紒");
				}
			}

			// private String password2; 涓ゆ瀵嗙爜瑕佷竴鑷�
			if (this.confirmPwd != null) {
				if (!this.confirmPwd.equals(this.userPwd)) {
					isOk = false;
					errors.put("confirmPwd", "涓ゆ瀵嗙爜涓嶄竴鑷达紒锛�");
				}
			}

			// private String email; 鍙互涓虹┖锛屼笉涓虹┖瑕佹槸涓�涓悎娉曠殑閭
			if (this.email != null && !this.email.trim().equals("")) {
				if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
					isOk = false;
					errors.put("email", "閭涓嶆槸涓�涓悎娉曢偖绠憋紒锛�");
				}
			}

			// private String birthday; 鍙互涓虹┖锛屼笉涓虹┖鏃讹紝瑕佹槸涓�涓悎娉曠殑鏃ユ湡
			if (this.birthday != null && !this.birthday.trim().equals("")) {
				try {
					DateLocaleConverter conver = new DateLocaleConverter();
					conver.convert(this.birthday);
				} catch (Exception e) {
					isOk = false;
					errors.put("birthday", "鐢熸棩蹇呴』瑕佹槸涓�涓棩鏈燂紒锛�");
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
