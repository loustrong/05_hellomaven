package com.wistron;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //创建Session
        request.getSession();
        out.write("本网站有如下书：<br/>");
        Set<Map.Entry<String,Book>> set = DB.getAll().entrySet();
        for(Map.Entry<String,Book> me : set){
            Book book = me.getValue();
            String url =request.getContextPath()+ "/BuyServlet?id=" + book.getId();
            //response. encodeURL(java.lang.String url)用于对表单action和超链接的url地址进行重写
            url = response.encodeURL(url);//将超链接的url地址进行重写
            out.println(book.getName()  + "   <a href='"+url+"'>购买</a><br/>");
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
/**
 * @author gacl
 * 模拟数据库
 */
class DB{
    private static Map<String,Book> map = new LinkedHashMap<String,Book>();
    static{
        map.put("1", new Book("1","javaweb开发"));
        map.put("2", new Book("2","spring开发"));
        map.put("3", new Book("3","hibernate开发"));
        map.put("4", new Book("4","struts开发"));
        map.put("5", new Book("5","ajax开发"));
    }
    
    public static Map<String,Book> getAll(){
        return map;
    }
}

class Book{
    
    private String id;
    private String name;

    public Book() {
        super();
    }
    public Book(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
