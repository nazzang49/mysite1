<%@page import="com.cafe24.mysite.vo.GuestBookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<GuestBookVO> list = (List<GuestBookVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite1/guestbook?a=add" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="contents" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
						<%
						int count = list.size();
						int idx = 0;
						for(GuestBookVO vo : list){
						%>
							<li>
								<br>
								<table width=510 border=1>
									<tr>
										<td>[<%=count-idx++ %>]</td>
										<td><%=vo.getName()%></td>
										<td><%=vo.getReg_date()%></td>
										<!-- get 방식 파라미터 전송 -->
										<td><a href="<%=request.getContextPath() %>/guestbook?a=deleteform&no=<%=vo.getNo()%>">삭제</a></td>
										<td><a href="<%=request.getContextPath() %>/guestbook?a=updateform&no=<%=vo.getNo()%>">수정</a></td>
									</tr>
									<tr>
										<!-- 개행처리 -->
										<td colspan=4><%=vo.getContents().replaceAll("\n", "<br>")%></td>
									</tr>
								</table>
							</li>
					<%} %>
				</ul>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	</div>
</body>
</html>