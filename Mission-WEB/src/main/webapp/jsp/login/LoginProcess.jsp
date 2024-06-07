<%@page import="kr.ac.kopo.member.MemberDAO"%>
<%@page import="kr.ac.kopo.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	작업순서
	1. 파라미터 추출(id, pwd)
	2. DB Data 와 파라미터 일치여부 비교
	3. 결과출력
		로그인 성공 -> index.jsp
		로그인 실패 -> login.jsp
 --%>
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
	
	//아이디저장
	if(request.getParameter("fixedid")!=null){
		Cookie cookie = new Cookie("userId", id);
		response.addCookie(cookie);
	}else{
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				
				if(cookie.getName().equals("userId")){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		}
	}
	
	if(userVO == null){
		//로그인 실패
		url = "login.jsp";
		msg = "아이디 또는 패스워드를 잘못 입력하셨습니다.";
	}else{
		//로그인 성공
		url = "/Mission-WEB";
		msg = userVO.getName()+ " 님 환영합니다.";
	}
	
	pageContext.setAttribute("url", url);
	pageContext.setAttribute("msg", msg);
	
	session.setAttribute("userVO", userVO);
%>
<script>
	location.href = '${ url }'
	alert('${ msg }')
</script>