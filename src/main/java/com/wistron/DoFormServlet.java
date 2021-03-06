package com.wistron;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean b = isRepeatSubmit(request);
        if(b==true){
System.out.println("Do not repeat");
            return;
        }
        request.getSession().removeAttribute("token");
        System.out.println("Is process the request of user");
    }
    
   
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        
        if(client_token==null){
            return true;
        }
        
        String server_token = (String) request.getSession().getAttribute("token");
        
        if(server_token==null){
            return true;
        }
        
        if(!client_token.equals(server_token)){
            return true;
        }
        
        return false;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
