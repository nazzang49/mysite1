package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.UserDAO;
import com.cafe24.mysite.vo.UserVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		System.out.println(email);
		System.out.println(pw);
		
		UserDAO dao = new UserDAO();
		//인증이 완료된 사용자
		UserVO authUser = dao.get(email, pw);
		//입력값에 해당하는 사용자 정보가 없는 경우 = 재로그인
		if(authUser==null) {
			WebUtil.forward(request, response, "WEB-INF/views/user/loginform.jsp");
			return;
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		//메인으로 이동(index.jsp)
		WebUtil.redirect(request, response, request.getContextPath());
	}

}
