package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.UserDAO;
import com.cafe24.mysite.vo.UserVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class UpdateformAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//접근 제어
		HttpSession session = request.getSession();
		//세션 자체가 없거나 authUser 세션이 없다면
		if(session==null) {
			WebUtil.redirect(request, response, request.getContextPath());
			return;
		}
		
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		if(authUser==null) {
			WebUtil.redirect(request, response, request.getContextPath());
			return;
		}
		
		Long userNo = authUser.getNo();
		UserDAO dao = new UserDAO();
		//현재 가입되어 있는 회원 정보 호출
		UserVO vo = dao.get(userNo);
		
		request.setAttribute("vo", vo);
		request.setAttribute("no", userNo);
		WebUtil.forward(request, response, "/WEB-INF/views/user/updateform.jsp");
		
	}

}
