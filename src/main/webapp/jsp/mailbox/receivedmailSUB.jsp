<%@page import="kr.ac.kopo.vo.MailVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	String user = request.getParameter("id");

	List<MailVO> maillist = new ArrayList<>();

	StringBuilder sql = new StringBuilder();
	sql.append("select no, title, id, to_char(reg_date, 'yyyy-mm-dd')reg_date ");
	sql.append("  from tbl_mail ");
	sql.append(" where received_id = ? ");
	sql.append(" order by reg_date ");
	
	try(
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	){
		pstmt.setString(1, user);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			
			int location = 1;
			
			int no = rs.getInt(location);
			String title = rs.getString(location++);
			String received_id = rs.getString(location++);
			String regDate = rs.getString(location++);
			
			MailVO mail = new MailVO(no, received_id, title, regDate);
			maillist.add(mail);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	session.setAttribute("user", user);
	pageContext.setAttribute("maillist", maillist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인 이후 메일함 화면<br>
	받은메일함(Main)<br>
	보낸메일함 sendmail.jsp<br>
	즐겨찾기 favoritemail.jsp<br>
	휴지통 binmail.jsp<br>
	<table>
	<tr>
		<td>
			<a href="receivedmail.jsp">받은메일함</a> |
			<a href="sendmail.jsp">보낸메일함</a> |
			<a href="favoritemail.jsp">즐겨찾기</a> |
			<a href="binmail.jsp">휴지통</a> |
		</td>
	</tr>
	</table>
	<h3>
		<c:if test="${ not empty user }">
			[${ user }님 환영합니다]
		</c:if>
		<c:if test="${ empty user }">
			[GUEST님 환영합니다]
		</c:if>
	</h3>
	<hr>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>보낸사람</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${ maillist }" var="mail">
			<tr>
				<td>${ mail.no }</td>
				<td>
					<a href="detail.jsp?no=${ mail.no }">
					${ mail.title }
					</a>
				</td>
				<td>${ mail.id }</td>
				<td>${ mail.reg_date }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>