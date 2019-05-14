package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.UserDAO;
import com.cafe24.mysite.vo.UserVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		
		UserVO vo = new UserVO();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPw(pw);
		vo.setGender(gender);
		
		UserDAO dao = new UserDAO();
		boolean flag = dao.insert(vo);
		
		//처리 후 응답 결정
		if(flag) {
			WebUtil.redirect(request, response, request.getContextPath()+"/user?a=joinsuccess");
		}
	}
}
