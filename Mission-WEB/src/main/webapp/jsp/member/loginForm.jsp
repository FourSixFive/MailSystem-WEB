<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h2>회원가입</h2>
		<hr>
		<form name="loginForm" action="login.jsp" method="post">
			<table>
				<tr>
					<th>ID</th>
				</tr>
				<tr>
					<th>PASSWORD</th>
				</tr>
			</table>
		</form>
		</div>
	</section>
	<footer>
		<%@ include file="/include/footer.jsp" %>
	</footer>
</body>
</html>