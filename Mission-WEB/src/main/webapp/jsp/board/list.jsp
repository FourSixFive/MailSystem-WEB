<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@page import="kr.ac.kopo.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.ac.kopo.board.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<BoardVO> boardList = new ArrayList<>();
	
	StringBuilder sql = new StringBuilder();
	sql.append("select no, title, writer, to_char(reg_date, 'yyyy-mm-dd')reg_date ");
	sql.append("  from t_board");
	sql.append(" order by no desc ");
	
	try(
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	){
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String regDate = rs.getString("reg_date");

			BoardVO board = new BoardVO(no, title, writer, regDate);
			boardList.add(board);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	pageContext.setAttribute("boardList", boardList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-WEB/resources/css/Layout.css">
<link rel="stylesheet" href="/Mission-WEB/resources/css/table.css">
<script src="../jquery/lib/jquery-3.7.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#addBtn').click(function(){
			location.href = 'writeForm.jsp'
		})
	})
</script>
</head>
<body>
	<header>
		<jsp:include page="/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>전체게시글</h2>
		<hr>
		<br>
		<table border="1" style="width: 100%;" class="listodd">
			<tr>
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="17%">작성자</th>
				<th width="20%">등록일</th>
			</tr>
			<c:forEach items="${ boardList }" var="board">
				<tr>
					<td>${ board.no }</td>
					<td>
						<a href="detail.jsp?no=${ board.no }">
							<c:out value="${ board.title }" />
						</a>
					</td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		<button id="addBtn">새 글 등록</button>
	</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>