<%@ page session = "false" %>
<%@ page import="com.springmvc.DTO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members Administration</title>
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
    <div class="container mt-5" style="padding:140px 0 80px 0;">
  		<div class="pb-4">
			<h1>멤버관리</h1>
		</div>
            <table class="table table-striped table-hover">
			<tr>
				<th>아이디</th><th>이메일</th><th>이름</th><th>닉네임</th><th>전화번호</th><th>비고</th>
			</tr>
			<c:forEach var="member" items="${members}">
				<tr>
					<td>${member.getUserId()}</td><td>${member.getEmail()}</td><td>${member.getName()}</td><td>${member.getNikName()}</td><td>${member.getPhone()}</td><td>	<a href="deleteMember?userId=${member.getUserId()}" class="btn btn-danger">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="footer.jsp" %>	
</body>
</html>