package com.wistron;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestDemo02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setCharacterEncoding("UTF-8");
	        
	        response.setHeader("content-type", "text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        Enumeration<String> reqHeadInfos = request.getHeaderNames();//
	        out.write("��ȡ���Ŀͻ������е�����ͷ��Ϣ���£�");
	        out.write("<hr/>");
	        while (reqHeadInfos.hasMoreElements()) {
	            String headName = (String) reqHeadInfos.nextElement();
	            String headValue = request.getHeader(headName);
	            out.write(headName+":"+headValue);
	            out.write("<br/>");
	        }
	        out.write("<br/>");
	        out.write("��ȡ���Ŀͻ���Accept-Encoding����ͷ��ֵ��");
	        out.write("<hr/>");
	        String value = request.getHeader("Accept-Encoding");//ֵ
	        out.write(value);
	        
	        Enumeration<String> e = request.getHeaders("Accept-Encoding");
	        while (e.hasMoreElements()) {
	            String string = (String) e.nextElement();
	            System.out.println(string);
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
