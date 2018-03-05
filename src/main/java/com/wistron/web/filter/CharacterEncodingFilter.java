package com.wistron.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

private String encoding=null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//encoding鍦╳eb.xml涓寚瀹�
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//瑙ｅ喅琛ㄥ崟鎻愪氦鏃剁殑涓枃涔辩爜闂
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}
