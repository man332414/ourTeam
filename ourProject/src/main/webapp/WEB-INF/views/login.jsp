<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container d-grid justify-content-center" style="padding:300px 0 150px 0;">
		<div class="pb-4">
			<h1>로그인</h1>
		</div>
		<form action="login" method="post">
			<table class="table">
				<tr class="mb-3">
					<td>아이디 : </td><td><input type="text" name="userId"></td>
					
				</tr>
				<tr class="mb-3">
					<td>비밀번호 : </td><td><input type="password" name="password"></td>
				</tr>
				<tr class="mb-3">
					<td colspan="2"><input class="btn btn-primary" type="submit" value="접속"></td>
				</tr>
			</table>
		</form>
	</div>
<script>
	let error = ${error};
	console.log("error : "+error);
	if(error == 'true' || error == true)
		{
			alert("아이디 또는 비밀번호를 확인하세요");
		}
</script>
	<%@ include file="footer.jsp" %>
</body>
</html>