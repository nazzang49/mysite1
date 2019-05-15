package com.cafe24.mysite.action.user;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		UserDAO dao = new UserDAO();
		//인증이 완료된 사용자
		UserVO vo = dao.get(email, pw);
		//입력값에 해당하는 사용자 정보가 없는 경우 = 재로그인
		if(vo==null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter p = response.getWriter();
			p.println("<script>");
			p.println("alert('회원정보 없음 / 회원가입 요망');");
			p.println("</script>");
			p.close();
			
			//회원가입 페이지로 이동
			WebUtil.redirect(request, response, request.getContextPath()+"/user?a=joinform");
			return;
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("vo", vo);
		//메인으로 이동(index.jsp)
		WebUtil.redirect(request, response, request.getContextPath());
	}
}
