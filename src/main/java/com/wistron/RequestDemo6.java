package com.wistron;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo6
 */

public class RequestDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String data="��Һã����ǹ°����ǣ��������ܽ�JavaWeb";
	        /**
	         * �����ݴ�ŵ�request������,��ʱ��request������һ��Map������ʹ��
	         */
	        request.setAttribute("data", data);
	        //�ͻ��˷���RequestDemo06���Servlet��RequestDemo06֪ͨ������������ת��(forward)��test.jspҳ����д���
	        request.getRequestDispatcher("/test.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
