<%@page import="kr.ac.kopo.board.BoardVO"%>
<%@page import="kr.ac.kopo.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	http://localhost:8080/Mission-WEB/jsp/board/detail.jsp?no=25 요청
	
	작업순서
	1. 파라미터 추출(게시글 번호)
	2. 추출된 번호에 해당하는 게시글 조회(t_board)
	2-1. 공유영역 게시글 등록
	3. 조회된 게시글을 출력(WEB browser)
 --%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	
	BoardDAO boardDao = new BoardDAO();
	boardDao.viewCnt(no);
	BoardVO board = boardDao.selectByNo(no);
	pageContext.setAttribute("board", board);
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
		$('#returnBtn').click(function(){
			location.href = 'list.jsp'
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
		<h2>게시글 내용</h2>
		<hr>
		<br>
		<table style="width: 100%" border="1">
			<tr>
				<th width="25%">번호</th>
				<td>${ board.no }</td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td>${ board.content }</td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${ board.regDate }</td>
			</tr>
		</table>
	</div>
	<div align="center" class="alink">
		<button id="returnBtn">목록으로</button>
		<a href="updateForm.jsp?no=${ board.no }" class="alink">
			<button id="updateBtn">수정하기</button>
		</a>
		<a href="delete.jsp?no=${ board.no }" class="alink">
			<button id="deleteBtn">삭제하기</button>
		</a>
	</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>