<%@page import="com.cafe24.mysite.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVO vo = (UserVO)request.getAttribute("vo");
	Long no = (Long)request.getAttribute("no");
	
%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보 변경</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<div id="content">
			<div id="user">
				<form id="update-form" name="updateForm" method="post" action="<%=request.getContextPath()%>/user">
				<input type="hidden" name="a" value="update">
				<input type="hidden" name="no" value="<%=no%>">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="<%=vo.getName()%>">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="<%=vo.getEmail()%>">
					
					<label class="block-label">패스워드</label>
					<input name="pw" type="password" value="<%=vo.getPw()%>">
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="수정">
					
				</form>
			</div>
		</div>
		<div id="navigation">
			<ul>
				<li><a href="">안대혁</a></li>
				<li><a href="">방명록</a></li>
				<li><a href="">게시판</a></li>
			</ul>
		</div>
		<div id="footer">
			<p>(c)opyright 2015, 2016, 2017, 2018</p>
		</div>
	</div>
</body>
</html>