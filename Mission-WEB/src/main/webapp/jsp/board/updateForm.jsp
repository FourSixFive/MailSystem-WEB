<%@page import="kr.ac.kopo.board.BoardDAO"%>
<%@page import="kr.ac.kopo.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO boardDao = new BoardDAO();
	BoardVO board = new BoardVO();
	board = boardDao.selectByNo(no);
	board.setNo(no);
	
	pageContext.setAttribute("board", board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-WEB/resources/css/Layout.css">
<link rel="stylesheet" href="/Mission-WEB/resources/css/table.css">
<script>
	let isNull = function(obj){
		if(obj.value == '')return true
		return false
	}

	let checkForm = function(){
		
		let f = document.inputForm
		
		if(f.title.value == ''){
			alert('제목을 입력해주세요')
			f.title.focus()
			return false
		}
		
		if(isNull(f.writer)){
			alert('작성자를 입력해주세요')
			f.writer.focus()
			return false
		}

		if(isNull(f.content)){
			alert('내용을 입력해주세요')
			f.content.focus()
			return false
		}
		
		return true
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>글 수정하기</h2>
		<hr>
		<form name="inputForm" action="write.jsp" method="post" onsubmit="return checkForm()">
			<table style="width: 100%" border="1">
				<tr>
					<th width="25%">제목</th>
					<td>
						<input type="text" name="title" size="80" value="${ board.title }">
					</td>
				</tr>
				<tr>
					<th width="25%">작성자</th>
					<td>
						<input type="text" name="writer" size="80" value="${ board.writer }">
					</td>
				</tr>
				<tr>
					<th width="25%">내용</th>
					<td>
						<textarea name="content" cols="100" rows="20" placeholder="${ board.content }"></textarea>
					</td>
				</tr>
			</table>
				<input type="hidden" name="no" value="${ board.no }">
			<br>
			<button type="submit">수정하기</button>
		</form>
	</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>