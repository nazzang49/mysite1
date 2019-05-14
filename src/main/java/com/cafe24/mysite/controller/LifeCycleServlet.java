package com.cafe24.mysite.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//init(최초에 한번만 호출) -> service -> get or post
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init();
		Map map = new HashMap();
		//서블릿 영역에서 속성 데이터로 저장 가능
		getServletContext().setAttribute("cacheUser", map);
		System.out.println("init() called");
	}

	public void destroy() {
		System.out.println("destroy() called");
		super.destroy();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() called");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() called");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>LifeCycle</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
