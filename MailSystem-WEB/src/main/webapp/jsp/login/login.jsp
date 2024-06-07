<%@page import="kr.ac.kopo.dao.MemberDAO"%>
<%@page import="kr.ac.kopo.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberVO loginVO = new MemberVO();
	loginVO.setId(id);
	loginVO.setPassword(password);
	
	MemberDAO memberDao = new MemberDAO();
	MemberVO userVO = memberDao.login(loginVO);
	
	String url = "";
	String msg = "";
	if(userVO == null){
		
		//로그인 실패
		url = "login.jsp";
		msg = "아이디 또는 패스워드를 잘못 입력하셨습니다.";
	}else{
		
		//로그인 성공
		url = "/jsp/mailbox/home.jsp";
		msg = userVO.getName()+ "님 환영합니다.";
	}
	
	pageContext.setAttribute("url", url);
	pageContext.setAttribute("msg", msg);
	
	session.setAttribute("userVO", userVO);
%>
<script>
	location.href = '${ url }'
	alert('${ msg }')
</script>