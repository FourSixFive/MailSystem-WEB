<%@page import="kr.ac.kopo.member.MemberDAO"%>
<%@page import="kr.ac.kopo.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email = request.getParameter("e-mail");
	String domain = request.getParameter("domain");
	String tel1 = "010";
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String phone = tel1+'-'+tel2+'-'+tel3;
	String post = request.getParameter("postcode");
	String basicAddr = request.getParameter("basic-addr");
	String detailAddr = request.getParameter("detail-addr");
	
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setName(name);
	member.setPassword(password);
	member.setEmail(email);
	member.setDomain(domain);
	member.setPhone(phone);
	member.setPost(post);
	member.setBasicAddr(basicAddr);
	member.setDetailAddr(detailAddr);

	MemberDAO memberDao = new MemberDAO();
	memberDao.insertmember(member);
%>
<script>
	//step 03
	alert('회원가입을 완료하였습니다')
	location.href = "/Mission-WEB"
</script>