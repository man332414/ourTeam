<%@ page import="com.springmvc.DTO.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Members Administration</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div>
		<p><h1>멤버 관리 페이지 입니다.</h1>
		<table >
			<tr>
				<th>아이디</th><th>이메일</th><th>이름</th><th>닉네임</th><th>전화번호</th><th>비고</th>
			</tr>
			<c:forEach var="member" items="${members}">
				<tr>
					<td>${member.getUserId()}</td><td>${member.getEmail()}</td><td>${member.getName()}</td><td>${member.getNikName()}</td><td>${member.getPhone()}</td><td>	<a href="deleteMember?userId=${member.getUserId()}">삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>