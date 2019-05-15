package com.cafe24.mysite.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mysite.dao.UserDAO;
import com.cafe24.mysite.vo.UserVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		UserVO vo = new UserVO();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPw(pw);
		
		UserDAO dao = new UserDAO();
		boolean flag = dao.update(Long.parseLong(no),vo);
		
		//수정 완료
		if(flag) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>");
			writer.println("alert('회원정보 변경 완료');");
			writer.println("</script>");
			
			//변경 후 메인 이동
			WebUtil.redirect(request, response, request.getContextPath());		
		}else {
			//이전 페이지로
			System.out.println("변경실패");
		}
	}
}
