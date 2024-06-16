<%@page extends="kr.ac.kopo.util.ExtendMailService" %>
<%@page import="kr.ac.kopo.vo.MailVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.dao.MailDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	
	MailVO mail = new MailVO();
	mail = service2.receivedmail_WEB(no);
	
	pageContext.setAttribute("mail", mail);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<td>${ mail.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${ mail.title }</td>
		</tr>
		<tr>
			<th>보낸사람</th>
			<td>${ mail.received_id }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${ mail.contents }</td>
		</tr>
		<tr>
			<th>보낸날짜</th>
			<td>${ mail.reg_date }</td>
		</tr>
	</table>
</body>
</html>