package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.vo.GuestBookVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class DeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		
		GuestBookVO vo = new GuestBookVO();
		long num = Long.parseLong(no);
		vo.setNo(num);
		vo.setPassword(password);
		
		WebUtil.redirect(request, response, request.getContextPath()+"/guestbook");	
	}
}
