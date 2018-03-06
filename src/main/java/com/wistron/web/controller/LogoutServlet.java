package com.wistron.web.controller;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute("user");
		//
		//MessageFormat.format
		String tempStr1 = MessageFormat.format(
				"注销成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url={0}'/>",  
				request.getContextPath()+"/servlet/LoginUIServlet");
		System.out.println(tempStr1);//
		System.out.println("---------------------------------------------------------");
		/**
		 *
		 * <meta http-equiv=''refresh'' content=''3;url={0}''/>"
		 * MessageFormat.format("<meta http-equiv=''refresh'' content=''3;url={0}''/>","index.jsp")灏卞彲浠ユ甯歌繑鍥�
		 * <meta http-equiv=''refresh'' content=''3;url=index.jsp'/>
		 */
		String tempStr2 = MessageFormat.format(
				"注销成功！！3秒后为您自动跳到登录页面！！<meta http-equiv=''refresh'' content=''3;url={0}''/>",
				request.getContextPath()+"/servlet/LoginUIServlet");
		/**
		 * 
		 * 
		 * <meta http-equiv='refresh' content='3;url=/webmvcframework/servlet/LoginUIServlet'/>
		 */
		System.out.println(tempStr2);
		
		String message = String.format(
				"注销成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>", 
				request.getContextPath()+"/servlet/LoginUIServlet");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
