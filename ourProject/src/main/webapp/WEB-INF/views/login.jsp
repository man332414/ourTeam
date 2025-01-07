<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
    <style>
        body 
        {
            background-color: #fefcf8; /* 배경색 설정 */
        }
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container d-grid justify-content-center" style="padding:330px 0 230px 0;">
		<div class="pb-4">
			<h1>로그인</h1>
		</div>
		<form action="login" method="post">
			<table>
				<tr style="height:60px; vertical-align:top;">
					<td>아이디 : </td><td><input type="text" name="userId"></td>
					
				</tr>
				<tr style="height:60px; vertical-align:top;">
					<td>비밀번호 : </td><td><input type="password" name="password"></td>
				</tr>
				<tr style="height:60px; vertical-align:top; text-align:right;">
					<td colspan="2"><input class="btn btn-primary" type="submit" value="접속"></td>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="footer.jsp" %>
<script>
	document.addEventListener("DOMContentLoaded", isError)
	let error = <%=request.getParameter("error")%>;
	console.log("error : "+error);
	function isError()
	{
		if(error == 'true' || error == true)
			{
				alert("아이디 또는 비밀번호를 확인하세요");
			}
	}
</script>
</body>
</html>