package com.wistron;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo01
 */

public class CookieDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  //���÷���������UTF-8����������
        response.setCharacterEncoding("UTF-8");
        //�����������UTF-8������н���,���������������
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //��ȡ��������ʷ��ʷ�����ʱ���ݹ�����cookie����
        Cookie[] cookies = request.getCookies();
        //����û��ǵ�һ�η��ʣ���ô�õ���cookies����null
        if (cookies!=null) {
            out.write("���ϴη��ʵ�ʱ���ǣ�");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastAccessTime")) {
                    Long lastAccessTime =Long.parseLong(cookie.getValue());
                    Date date = new Date(lastAccessTime);
                    out.write(date.toLocaleString());
                }
            }
        }else {
            out.write("��������һ�η��ʱ�վ��");
        }
        
        //�û����ʹ�֮�����������û��ķ���ʱ�䣬�洢��cookie�У�Ȼ���͵��ͻ��������
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");//����һ��cookie��cookie��������lastAccessTime
        //��cookie������ӵ�response�����У����������������response�����е�����ʱ�ͻ��cookieҲ������ͻ��������
        cookie.setMaxAge(24*60*60);
        response.addCookie(cookie);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
