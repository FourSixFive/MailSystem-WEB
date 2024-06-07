<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Cookie[] cookies = request.getCookies();
	
	String userId = "";
	
	if(cookies != null){
		for(Cookie cookie : cookies){
			
			if(cookie.getName().equals("userId")){
				userId = cookie.getValue();
				break;
			}
		}
	}
	
	pageContext.setAttribute("userId", userId);
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
		
		let f = document.LoginForm
		
		if(isNull(f.id, '아이디를 입력하세요'))return false
		
		if(isNull(f.password, '패스워드를 입력하세요'))return false
		
		return true
	}
	
	let chk = ${ userId }
	
	if(chk != null){
		 $('input:checkbox[name=fixedidTag]').attr("checked", true).parent().addClass('on');
	}
	
</script>
</head>
<body>
	<header>
		<jsp:include page="/include/topMenu.jsp"></jsp:include>
	</header>
	<section>
		<div align="center">
		<br>
		<hr>
		<h2>로그인</h2>
		<hr>
		<br>
		<form action="LoginProcess.jsp" method="post" name="LoginForm" onsubmit="return checkForm()">
			<table style="width: 40%;">
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="id" value="${ userId }"><br>
						<span id="saveId">
							<c:if test="${ userId eq '' }">
								<input type="checkbox" name="fixedid">
							</c:if>
							<c:if test="${ userId ne '' }">
								<input type="checkbox"checked name="fixedid">
							</c:if>
								아이디저장
						</span>
					</td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
			</table>
			<button>로그인</button>
		</form>
		</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>