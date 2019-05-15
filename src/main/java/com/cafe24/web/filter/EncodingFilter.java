package com.cafe24.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//web.xml 등록 대신 애노테이션을 활용한 필터 등록
//@WebFilter(value="/*", initParams=@WebInitParam(name="encoding",value="utf-8"))
public class EncodingFilter implements Filter {

	private String encoding = null;
	
	//web.xml에서 init 설정 필요
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodingFilter init() called");
		encoding = fConfig.getInitParameter("encoding");
		if(encoding==null) {
			encoding="utf-8";
		}
	}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	request.setCharacterEncoding(encoding);
    	chain.doFilter(request, response);
    }
    
	public void destroy() {
		
	}
}