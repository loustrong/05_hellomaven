package com.wistron;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestDemo03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        request.setCharacterEncoding("UTF-8");
        /**
         *
           <input type="text" name="userid" value="NO." size="2" maxlength="2">
         */
        String userid = request.getParameter("userid");//<input type="text" name="userid">
        /**
         * <input type="text" name="username" value="">
         */
        String username = request.getParameter("username");//��ȡ��д���û���
        /**
         * <input type="password" name="userpass" value="">
         */
        String userpass = request.getParameter("userpass");//
        String sex = request.getParameter("sex");//
        String dept = request.getParameter("dept");//
        //
        String[] insts = request.getParameterValues("inst");
        String note = request.getParameter("note");//
        String hiddenField = request.getParameter("hiddenField");//
        
        String instStr="";
        /**
         * 
         */
        for (int i = 0; insts!=null && i < insts.length; i++) {
            if (i == insts.length-1) {
                instStr+=insts[i];
            }else {
                instStr+=insts[i]+",";
            }
        }
        
        String htmlStr = "<table>" +
                            "<tr><td>��д�ı�ţ�</td><td>{0}</td></tr>" +
                            "<tr><td>��д���û�����</td><td>{1}</td></tr>" +
                            "<tr><td>��д�����룺</td><td>{2}</td></tr>" +
                            "<tr><td>ѡ�е��Ա�</td><td>{3}</td></tr>" +
                            "<tr><td>ѡ�еĲ��ţ�</td><td>{4}</td></tr>" +
                            "<tr><td>ѡ�е���Ȥ��</td><td>{5}</td></tr>" +
                            "<tr><td>��д��˵����</td><td>{6}</td></tr>" +
                            "<tr><td>����������ݣ�</td><td>{7}</td></tr>" +
                        "</table>";
        htmlStr = MessageFormat.format(htmlStr, userid,username,userpass,sex,dept,instStr,note,hiddenField);
        
        response.setCharacterEncoding("UTF-8");//���÷���������UTF-8����������ݵ��ͻ���
        response.setContentType("text/html;charset=UTF-8");//���ÿͻ����������UTF-8�����������
        response.getWriter().write(htmlStr);//���htmlStr��������ݵ��ͻ����������ʾ
        
      //request�����װ�Ĳ�������Map����ʽ�洢��
        Map<String, String[]> paramMap = request.getParameterMap();
        for(Map.Entry<String, String[]> entry :paramMap.entrySet()){
            String paramName = entry.getKey();
            String paramValue = "";
            String[] paramValueArr = entry.getValue();
            for (int i = 0; paramValueArr!=null && i < paramValueArr.length; i++) {
                if (i == paramValueArr.length-1) {
                    paramValue+=paramValueArr[i];
                }else {
                    paramValue+=paramValueArr[i]+",";
                }
            }
            System.out.println(MessageFormat.format("{0}={1}", paramName,paramValue));
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
