package com.cafe24.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class ContextLoadListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce)  {
		//applicationContext.xml 파일의 경로
		String contextConfigLocation = sce.getServletContext().getInitParameter("contextConfigLocation");
		System.out.println("Container Starts");
		System.out.println(contextConfigLocation);
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }
}
