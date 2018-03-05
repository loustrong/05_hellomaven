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
		//鐢变簬瀛楃涓蹭腑鍖呭惈鏈夊崟寮曞彿锛屽湪杩欑鎯呭喌涓嬩娇鐢∕essageFormat.format鏂规硶鎷兼帴瀛楃涓叉椂灏变細鏈夐棶棰�
		//MessageFormat.format鏂规硶鍙槸鎶婂瓧绗︿覆涓殑鍗曞紩鍙峰幓鎺夛紝涓嶄細灏嗗唴瀹瑰～鍏呭埌鎸囧畾鐨勫崰浣嶇涓�
		String tempStr1 = MessageFormat.format(
				"娉ㄩ攢鎴愬姛锛侊紒3绉掑悗涓烘偍鑷姩璺冲埌鐧诲綍椤甸潰锛侊紒<meta http-equiv='refresh' content='3;url={0}'/>", 
				request.getContextPath()+"/servlet/LoginUIServlet");
		System.out.println(tempStr1);//杈撳嚭缁撴灉锛氭敞閿�鎴愬姛锛侊紒3绉掑悗涓烘偍鑷姩璺冲埌鐧诲綍椤甸潰锛侊紒<meta http-equiv=refresh content=3;url={0}/>
		System.out.println("---------------------------------------------------------");
		/**
		 * 瑕佹兂瑙ｅ喅"濡傛灉瑕佹嫾鎺ョ殑瀛楃涓插寘鍚湁鍗曞紩鍙凤紝閭ｄ箞MessageFormat.format鏂规硶灏卞彧鏄妸瀛楃涓蹭腑鐨勫崟寮曞彿鍘绘帀锛屼笉浼氬皢鍐呭濉厖鍒版寚瀹氱殑鍗犱綅绗︿腑"杩欎釜闂锛�
		 * 閭ｄ箞鍙互闇�瑕佷娇鐢ㄥ崟寮曞彿寮曡捣鏉ョ殑瀛楃涓蹭腑浣跨敤2涓崟寮曞彿寮曡捣鏉ワ紝渚嬪锛�"<meta http-equiv=''refresh'' content=''3;url={0}''/>"
		 * 杩欐牱MessageFormat.format("<meta http-equiv=''refresh'' content=''3;url={0}''/>","index.jsp")灏卞彲浠ユ甯歌繑鍥�
		 * <meta http-equiv=''refresh'' content=''3;url=index.jsp'/>
		 */
		String tempStr2 = MessageFormat.format(
				"娉ㄩ攢鎴愬姛锛侊紒3绉掑悗涓烘偍鑷姩璺冲埌鐧诲綍椤甸潰锛侊紒<meta http-equiv=''refresh'' content=''3;url={0}''/>", 
				request.getContextPath()+"/servlet/LoginUIServlet");
		/**
		 * 杈撳嚭缁撴灉锛�
		 * 娉ㄩ攢鎴愬姛锛侊紒3绉掑悗涓烘偍鑷姩璺冲埌鐧诲綍椤甸潰锛侊紒
		 * <meta http-equiv='refresh' content='3;url=/webmvcframework/servlet/LoginUIServlet'/>
		 */
		System.out.println(tempStr2);
		
		String message = String.format(
				"娉ㄩ攢鎴愬姛锛侊紒3绉掑悗涓烘偍鑷姩璺冲埌鐧诲綍椤甸潰锛侊紒<meta http-equiv='refresh' content='3;url=%s'/>", 
				request.getContextPath()+"/servlet/LoginUIServlet");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
