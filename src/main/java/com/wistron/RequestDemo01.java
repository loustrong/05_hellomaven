package com.wistron;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
         *
         */
        
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
        String queryString = request.getQueryString();//
        String remoteAddr = request.getRemoteAddr();//ַ
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//ַ
        String localName = request.getLocalName();//
        response.setCharacterEncoding("UTF-8");//
        //ͨ
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("��ȡ���Ŀͻ�����Ϣ���£�");
        out.write("<hr/>");
        out.write("�����URL��ַ��"+requestUrl);
        out.write("<br/>");
        out.write("�������Դ��"+requestUri);
        out.write("<br/>");
        out.write("�����URL��ַ�и����Ĳ�����"+queryString);
        out.write("<br/>");
        out.write("�����ߵ�IP��ַ��"+remoteAddr);
        out.write("<br/>");
        out.write("�����ߵ���������"+remoteHost);
        out.write("<br/>");
        out.write("ʹ�õĶ˿ںţ�"+remotePort);
        out.write("<br/>");
        out.write("remoteUser��"+remoteUser);
        out.write("<br/>");
        out.write("����ʹ�õķ�����"+method);
        out.write("<br/>");
        out.write("pathInfo��"+pathInfo);
        out.write("<br/>");
        out.write("localAddr��"+localAddr);
        out.write("<br/>");
        out.write("localName��"+localName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
