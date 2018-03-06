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
		
		if (formbean.validate() == false) {//
			
			request.setAttribute("formbean", formbean);
			
			request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
			return;
		}

		User user = new User();
		try {
			// 
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean);//
			user.setId(WebUtils.makeId());//
			IUserService service = new UserServiceImpl();
			//
			
			service.registerUser(user);
			
			String message = String.format(
					"注册成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/pages/message.jsp").forward(request,response);

		} catch (UserExistException e) {
			formbean.getErrors().put("userName", "注册用户已存在！！");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // 
			request.setAttribute("message", "对不起，注册失败！！"+user.getUserName()+"  "+user.getUserPwd()+"  "+user.getId()+"  "+user.getEmail()+"  "+user.getBirthday());
			request.getRequestDispatcher("/pages/message.jsp").forward(request,response);
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
