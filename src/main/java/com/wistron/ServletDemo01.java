package com.wistron;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 int i=1;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        synchronized (this) {
	            i++;
	            try {
	                Thread.sleep(1000*4);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
	        out.println("<HTML>");
	        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
	        out.println("  <BODY>");
	        out.print("    This is ");
	        out.print(this.getClass());
	        out.println(", using the GET method\n");
	        out.println("<br>");
	        out.println(request.getContextPath());
	        out.println("<br>");
	        out.println(i);
	        out.println("<br>");
	        out.println("  </BODY>");
	        out.println("</HTML>");
	        out.flush();
	        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method\n");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
	}

}
