<%@page extends="kr.ac.kopo.util.ExtendMailService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = service.findmemberid(request.getParameter("name"), request.getParameter("phone"));
	
	if(id != null){
		pageContext.setAttribute("id", id);
	}else{
		id = "존재하지 않는 회원입니다";
		pageContext.setAttribute("id", id);
	}
%>
<script>
	alert(id)
	location.href = '/MailSystem-WEB/index.html'
</script>