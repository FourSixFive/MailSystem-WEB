<%@page import="kr.ac.kopo.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	MemberVO member = new MemberVO();
	member.setId(request.getParameter("id"));
	member.setPassword(request.getParameter("password"));
	member.setName(request.getParameter("name"));
	member.setPhone("010"+request.getParameter("midPhone")+request.getParameter("endPhone"));
	
	
%>
<script>
	alert('회원가입이 완료되었습니다')
	location.href = "/MailSystem-WEB/index.html"
</script>