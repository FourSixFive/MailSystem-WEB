<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/MailSystem-WEB/resources/js/myJS.js"></script>
<script>
	let checkForm = function(){
		
		let f = document.signUpForm
		
		if(isnull)(f.id, 'ID를 입력하세요')return false

		if(isnull)(f.password, '비밀번호를 입력하세요')return false
		
		if(isnull)(f.name, '이름을 입력하세요')return false
		
		if(isnull)(f.midPhone, '전화번호를 입력하세요')return false
		
		if(isnull)(f.endPhone, '전화번호를 입력하세요')return false
		
		return true
	}
</script>
</head>
<body>
	약관이 어쩌구<br>
	체크박스 동의<br>
	아이디, 비밀번호, 이름, 전화번호 입력하면 DB에 저장<br>
	이후 /index.jsp 화면으로 이동
	<form name="signUpForm" action="signUp.jsp" method="post" onsubmit="return chechForm()">
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="id" placeholder="ID 입력">
				</td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td>
					<input type="password" name="password" placeholder="password 입력">
				</td>
			</tr>
			<tr>
				<th>NAME</th>
				<td>
					<input type="text" name="name" placeholder="이름 입력">
				</td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td>010) <input type="text" name="midPhone"> - 
				<input type="text" name="endPhone">
				</td>
			</tr>
		</table>
		<button type="submit">가입</button>
	</form>
</body>
</html>