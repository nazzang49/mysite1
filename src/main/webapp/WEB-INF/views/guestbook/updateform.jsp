<%@page import="com.cafe24.mysite.vo.GuestBookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GuestBookVO vo = (GuestBookVO)request.getAttribute("vo");
	String str = (String)request.getAttribute("no");
	Long no = Long.parseLong(str);
%>
<!DOCTYPE html>
<html>
<head>
<title>방명록 변경</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite1/guestbook" method="post">
					<input type="hidden" name="a" value="update">
					<input type="hidden" name="no" value="<%=no%>">
					<table>
						<tr>
						<!-- 내용만 변경 가능 -->
							<td>이름</td><td><input type="text" name="name" value="<%=vo.getName()%>" readonly></td>
							<td>비밀번호</td><td><input type="password" name="pw"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="contents" id="content"><%=vo.getContents()%></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE="수정"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	</div>
</body>
</html>