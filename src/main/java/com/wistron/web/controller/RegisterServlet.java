package com.wistron.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.wistron.domain.User;
import com.wistron.exception.UserExistException;
import com.wistron.service.IUserService;
import com.wistron.service.impl.UserServiceImpl;
import com.wistron.util.WebUtils;
import com.wistron.web.formbean.RegisterFormBean;




public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RegisterFormBean formbean = WebUtils.request2Bean(request,RegisterFormBean.class);
		//鏍￠獙鐢ㄦ埛娉ㄥ唽濉啓鐨勮〃鍗曟暟鎹�
		if (formbean.validate() == false) {//濡傛灉鏍￠獙澶辫触
			//灏嗗皝瑁呬簡鐢ㄦ埛濉啓鐨勮〃鍗曟暟鎹殑formbean瀵硅薄鍙戦�佸洖register.jsp椤甸潰鐨刦orm琛ㄥ崟涓繘琛屾樉绀�
			request.setAttribute("formbean", formbean);
			//鏍￠獙澶辫触灏辫鏄庢槸鐢ㄦ埛濉啓鐨勮〃鍗曟暟鎹湁闂锛岄偅涔堝氨璺宠浆鍥瀝egister.jsp
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		try {
			// 娉ㄥ唽瀛楃涓插埌鏃ユ湡鐨勮浆鎹㈠櫒
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean);//鎶婅〃鍗曠殑鏁版嵁濉厖鍒癹avabean涓�
			user.setId(WebUtils.makeId());//璁剧疆鐢ㄦ埛鐨処d灞炴��
			IUserService service = new UserServiceImpl();
			//璋冪敤service灞傛彁渚涚殑娉ㄥ唽鐢ㄦ埛鏈嶅姟瀹炵幇鐢ㄦ埛娉ㄥ唽
			service.registerUser(user);
			String message = String.format(
					"娉ㄥ唽鎴愬姛锛侊紒3绉掑悗涓烘偍鑷姩璺冲埌鐧诲綍椤甸潰锛侊紒<meta http-equiv='refresh' content='3;url=%s'/>", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request,response);

		} catch (UserExistException e) {
			formbean.getErrors().put("userName", "娉ㄥ唽鐢ㄦ埛宸插瓨鍦紒锛�");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // 鍦ㄥ悗鍙拌褰曞紓甯�
			request.setAttribute("message", "瀵逛笉璧凤紝娉ㄥ唽澶辫触锛侊紒");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
