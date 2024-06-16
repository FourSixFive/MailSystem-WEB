<%@page extends="kr.ac.kopo.util.ExtendMailService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pwd = service.findmemberpwd(request.getParameter("id"), request.getParameter("name"), request.getParameter("phone"));
	
	if(pwd != null){
		pageContext.setAttribute("pwd", pwd);
	}else{
		pwd = "존재하지 않는 회원입니다";
		pageContext.setAttribute("id", pwd);
	}
%>
<script>
	alert(pwd)
	location.href = '/MailSystem-WEB/index.jsp'
</script>