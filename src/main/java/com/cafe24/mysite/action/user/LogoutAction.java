package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.vo.UserVO;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		//authUser에 해당하는 세션 데이터 호출
		UserVO vo = (UserVO)session.getAttribute("vo");
		//세션 정보가 없으면 메인으로 이동
		if(session!=null&&vo!=null) {
			//세션 제거 후 재정렬
			session.removeAttribute("vo");
			session.invalidate();
		}
		WebUtil.redirect(request, response, request.getContextPath());		
	}
}
