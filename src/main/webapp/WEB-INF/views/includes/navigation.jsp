<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="navigation">
	<ul>
		<c:choose>
			<c:when test='${param.menu == "main" }'>
				<li><a href="${pageContext.servletContext.contextPath }">안대혁</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/guestbook">방명록</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=board">게시판</a></li>
			</c:when>
			<c:when test='${param.menu == "guestbook" }'>
				<li class="selected"><a href="${pageContext.servletContext.contextPath }">안대혁</a></li>
				<li class="selected"><a href="${pageContext.servletContext.contextPath }/guestbook">방명록</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/guestbook?a=board">게시판</a></li>
			</c:when>
			<c:when test='${param.menu == "board" }'>
				<li class="selected"><a href="${pageContext.servletContext.contextPath }">안대혁</a></li>
				<li><a href="${pageContext.servletContext.contextPath }/guestbook">방명록</a></li>
				<li class="selected"><a href="${pageContext.servletContext.contextPath }/guestbook?a=board">게시판</a></li>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</ul>
</div>