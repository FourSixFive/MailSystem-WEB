<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1" style="width: 100%">
	<tr>
		<td rowspan="2" style="width: 300px; height: 70px;">
			<a href="/Mission-WEB">
				<img src="/Mission-WEB/resources/images/backjoon.png" style="width: 100%; height: 100%;">
			</a>
		</td>
		<td align="right">
			<c:if test="${ not empty userVO }">
				[${ userVO.name }(${ userVO.id })님 환영합니다]
			</c:if>
			<c:if test="${ empty userVO }">
				[GUEST님 환영합니다]
			</c:if>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${ userVO.type eq 'S' }">
				<a href="/Mission-WEB/jsp/member/memberlist.jsp">회원관리</a> |
			</c:if> 
			<a href="/Mission-WEB/jsp/board/list.jsp">게시판</a> | 
			<c:choose>
			<c:when test="${ empty userVO }">
			<a href="/Mission-WEB/jsp/member/signupForm.jsp">회원가입</a> |
			<a href="/Mission-WEB/jsp/login/login.jsp">로그인</a> | 
			</c:when>
			<c:otherwise>
			마이페이지 | 
			<a href="/Mission-WEB/jsp/login/logout.jsp">로그아웃</a>
			</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>