package com.cafe24.mysite.action.user;

import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

//서블릿에서 actionName을 전달받는 클래스
public class UserActionFactory extends ActionFactory{

	@Override
	public Action getAction(String actionName) {
		//이곳에서 다시 각 서비스 모듈에 해당하는 액션 클래스 호출
		Action action = null;
		if("joinform".equals(actionName)) {
			action = new JoinformAction();
		}else if("join".equals(actionName)) {
			action = new JoinAction();
		}else if("joinsuccess".equals(actionName)) {
			action = new JoinSuccessAction();
		}else if("loginform".equals(actionName)) {
			action = new LoginformAction();
		}else if("login".equals(actionName)) {
			action = new LoginAction();
		}else if("logout".equals(actionName)) {
			action = new LogoutAction();
		}else if("updateform".equals(actionName)) {
			action = new UpdateformAction();
		}else if("update".equals(actionName)) {
			action = new UpdateAction();
		}else {
			
		}
		return action;
	}
}
