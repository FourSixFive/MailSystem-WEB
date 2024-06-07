<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/Mission-WEB/resources/js/myJS.js"></script>
<script>
	let checkForm = function(){
		
		let f = document.LoginForm
		
		if(isNull(f.id, '아이디를 입력하세요'))return false
		
		if(isNull(f.password, '패스워드를 입력하세요'))return false
		
		return true
	}
</script>
</head>
<body>
	<header>
	</header>
	<section>
		<form action="jsp/login/login.jsp" method="post" onsubmit="return checkForm()">
			<table>
				<tr>
					<th>
						ID
					</th>
					<td>
						<input type="text">
					</td>
				</tr>
				<tr>
					<th>
						PASSWORD
					</th>
					<td>
						<input type="password">
					</td>
				</tr>
			</table>
			<button >로그인</button>
		</form>
		<div style="width:500px; height:400px; align:center;">
			<a href="/jsp/signup/signup.jsp">
				<span>회원가입</span>
				&nbsp;&nbsp;&nbsp;&nbsp;
			</a>
			<a href="/jsp/signup/find.jsp">
				<span>ID/PWD 찾기</span>
			</a>
		</div>
	</section>
	<footer>
	</footer>
</body>
</html>