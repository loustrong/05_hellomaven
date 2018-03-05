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
		//鑾峰彇鐢ㄦ埛濉啓鐨勭櫥褰曞瘑鐮�
		String password = request.getParameter("password");
		
		IUserService service = new UserServiceImpl();
		//鐢ㄦ埛鐧诲綍
		User user = service.loginUser(username, password);
		if(user==null){
			String message = String.format(
					"瀵逛笉璧凤紝鐢ㄦ埛鍚嶆垨瀵嗙爜鏈夎锛侊紒璇烽噸鏂扮櫥褰曪紒2绉掑悗涓烘偍鑷姩璺冲埌鐧诲綍椤甸潰锛侊紒<meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//鐧诲綍鎴愬姛鍚庯紝灏卞皢鐢ㄦ埛瀛樺偍鍒皊ession涓�
		request.getSession().setAttribute("user", user);
		String message = String.format(
				"鎭枩锛�%s,鐧婚檰鎴愬姛锛佹湰椤靛皢鍦�3绉掑悗璺冲埌棣栭〉锛侊紒<meta http-equiv='refresh' content='3;url=%s'", 
				user.getUserName(),
				request.getContextPath()+"/index.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
