<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="kr.ac.kopo.member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
		List<MemberVO> memberList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, password, email_id, email_domain, phone, post, basic_addr, detail_addr, TYPE, TO_CHAR(REG_DATE, 'yyyy-mm-dd') regDate ");
		sql.append("  from t_member");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email_id");
				String domain = rs.getString("email_domain");
				String phone = rs.getString("phone");
				String post = rs.getString("post");
				String basicAddr = rs.getString("basic_addr");
				String detailAddr = rs.getString("detail_addr");
				String type = rs.getString("TYPE");
				String regDate = rs.getString("regDate");

				MemberVO member = new MemberVO(id, name, password, email, domain, phone, post, basicAddr, detailAddr, type, regDate);
				memberList.add(member);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		pageContext.setAttribute("memberList", memberList);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-WEB/resources/css/Layout.css">
<link rel="stylesheet" href="/Mission-WEB/resources/css/table.css">
</head>
<body>
	<header>
		<jsp:include page="/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>전체회원 조회</h2>
		<hr>
		<br>
		<table border="1" style="width: 100%;">
			<tr>
				<th class="listth">아이디</th>
				<th class="listth">이름</th>
				<th class="listth">비밀번호</th>
				<th class="listth">이메일</th>
				<th class="listth">전화번호</th>
				<th class="listth">우편번호</th>
				<th class="listth">기본주소</th>
				<th class="listth">상세주소</th>
				<th class="listth">유저유형</th>
				<th class="listth">등록일</th>
			</tr>
			<c:forEach items="${ memberList }" var="member">
				<tr>
					<td class="listtd">${ member.id }</td>
					<td class="listtd">${ member.name }</td>
					<td class="listtd">${ member.password }</td>
					<td class="listtd">${ member.email }@${ member.domain }</td>
					<td class="listtd">${ member.phone }</td>
					<td class="listtd">${ member.post }</td>
					<td class="listtd">${ member.basicAddr }</td>
					<td class="listtd">${ member.detailAddr }</td>
					<td class="listtd">${ member.type }</td>
					<td class="listtd">${ member.regDate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>