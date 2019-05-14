package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.GuestBookDAO;
import com.cafe24.mysite.vo.GuestBookVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class AddAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//데이터를 받을 때는 기본적으로 문자열 기준
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String contents = request.getParameter("contents");
		
		//vo 객체 생성 후, DB insert를 위해 dao 객체 호출 및 메소드 실행
		GuestBookVO vo = new GuestBookVO();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContents(contents);
		
		new GuestBookDAO().insert(vo);
		WebUtil.redirect(request, response, request.getContextPath()+"/guestbook");
		
	}
	
}
