<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.cafe24.mysite.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/includes/header.jsp'/>
			<div id="wrapper">
				<div id="content">
					<div id="site-introduction">
						<img id="profile" src="https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-1/p240x240/30705531_2083087868372808_5261052926483232647_n.jpg?_nc_cat=0&oh=db97a9950eade94d765d2b566ff92fbc&oe=5BE17354">
						<h2>안녕, 내 홈페이지에 온 걸 환영해</h2>
						<p>
							[웹 프로그램밍 실습과제 예제 사이트]<br>
							메뉴는  사이트 소개/방명록/게시판 및 Python/데이터베이스/웹프로그래밍 수업<br><br>
							<a href="#">방명록</a>write now<br>
						</p>
					</div>
				</div>
			</div>
		<c:import url='/WEB-INF/views/includes/navigation.jsp'>
			<c:param name="menu" value="main"/>
		</c:import>
		<c:import url='/WEB-INF/views/includes/footer.jsp'/>
	</div>
</body>
</html>