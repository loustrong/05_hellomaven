package com.wistron.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wistron.domain.User;
import com.wistron.service.IUserService;
import com.wistron.service.impl.UserServiceImpl;




public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		//
		String password = request.getParameter("password");
		
		IUserService service = new UserServiceImpl();
		//
		User user = service.loginUser(username, password);
		if(user==null){
			String message = String.format(
					"对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
			return;
		}
		//鐧诲綍鎴愬姛鍚庯紝灏卞皢鐢ㄦ埛瀛樺偍鍒皊ession涓�
		request.getSession().setAttribute("user", user);
		String message = String.format(
				"恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'",  
				user.getUserName(),
				request.getContextPath()+"/pages/index.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
