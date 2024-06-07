<%@page import="kr.ac.kopo.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberVO userVO = new MemberVO();
	userVO.setId("user");
	session.setAttribute("userVO", userVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-WEB/resources/css/Layout.css">
<link rel="stylesheet" href="/Mission-WEB/resources/css/table.css">
<script src="/Mission-WEB/resources/js/myJS.js"></script>
<script>
	let checkForm = function(){
		
		let f = document.inputForm
		
		if(isNull(f.title, '제목을 입력하세요'))return false
		
		if(isNull(f.writer, '작성자를 입력하세요'))return false

		if(isNull(f.content, '내용을 입력하세요'))return false
		
		if(checkExt(f.attachedfile01)) return false
		if(checkExt(f.attachedfile02)) return false
		
		return true
	}
	
	let checkExt = function(obj){
		let forbidName = ['exe','bat','java','class','jsp']
		let fileName = obj.value
		let ext = fileName.substring(fileName.lastIndexOf('.')+1)
		
		for(let forbid of forbidName){
			if(forbid == ext){
				alert(`[${ ext }]`) 확장자는 파일 업로드 정책에 위배됩니다
				return true
			}
		}
			return false
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
		<h2>새글 등록</h2>
		<hr>
		<form name="inputForm" action="write.jsp" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
			<table style="width: 100%" border="1">
				<tr>
					<th width="25%">제목</th>
					<td>
						<input type="text" name="title" size="80">
					</td>
				</tr>
				<tr>
					<th width="25%">작성자</th>
					<td>
						<input type="text" name="writer" size="80">
					</td>
				</tr>
				<tr>
					<th width="25%">내용</th>
					<td>
						<textarea name="content" cols="100" rows="20"></textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="attachedfile01"><br>
						<input type="file" name="attachedfile02"><br>
					</td>
				</tr>
			</table>
			<br>
			<button type="submit">등 록</button>
		</form>
	</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>