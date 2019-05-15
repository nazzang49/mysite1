package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.GuestBookDAO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String no = request.getParameter("no");
		String contents = request.getParameter("contents");
		
		System.out.println(no);
		System.out.println(contents);
		
		GuestBookDAO dao = new GuestBookDAO();
		boolean flag = dao.update(Long.parseLong(no),contents);
		
		//수정완료(list.jsp로 이동)
		if(flag) {
			WebUtil.redirect(request, response, request.getContextPath()+"/guestbook");
		}
	}
}
