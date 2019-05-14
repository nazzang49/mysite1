package com.cafe24.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {

	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException, ServletException{
		System.out.println("url : "+url);
		response.sendRedirect(url);
	}
	
	public static void forward(HttpServletRequest request, HttpServletResponse response, String location) throws IOException, ServletException{
		request.getRequestDispatcher(location).forward(request, response);
	}
}
