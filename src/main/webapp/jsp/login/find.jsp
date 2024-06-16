<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
</script>
</head>
<body>
	ID/PWD 찾기<br>
	테이블에 ID, 이름, 전화번호 등을 확인<br>
	찾기가 완료되면 index.jsp로 이동<br>
	<hr>
	<h2>ID 찾기</h2>
	<hr>
	<form name="idForm" method="post" action="idFind.jsp">
		<table>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" placeholder="이름 입력">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="phone" placeholder="전화번호 입력">
				</td>
			</tr>
		</table>
		<button type="submit">찾기</button>
	</form>
	<hr>
	<h2>비밀번호 찾기</h2>
	<hr>
	<form name="passwordForm" method="post" action="pwdFind.jsp">
		<table>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="id" placeholder="ID 입력">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" placeholder="이름 입력">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="phone" placeholder="전화번호 입력">
				</td>
			</tr>
		</table>
		<button type="submit">찾기</button>
	</form>
</body>
</html>