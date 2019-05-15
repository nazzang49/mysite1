package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.GuestBookDAO;
import com.cafe24.mysite.vo.GuestBookVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class UpdateformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String no = request.getParameter("no");
		
		GuestBookDAO dao = new GuestBookDAO();
		GuestBookVO vo = dao.get(Long.parseLong(no));
		request.setAttribute("vo", vo);
		request.setAttribute("no", no);
		WebUtil.forward(request, response, "/WEB-INF/views/guestbook/updateform.jsp");	
	}
}

