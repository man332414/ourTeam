<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<%@ include file="header.jsp" %>
	<h1>로그인 페이지 입니다.</h1>
	<div>
		<form action="login" method="post">
			<table>
				<tr>
					<td>아이디 : </td><td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<td>비밀번호 : </td><td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td rowspan="2"><input type="submit" value="접속"></td>
				</tr>
			</table>
		</form>
	</div>
<script>
	if(error == 'true' || error == true)
		{
			arert("아이디 또는 비밀번호를 확인하세요");
		}
</script>
</body>
</html>