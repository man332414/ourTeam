<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<% 
		Date date = new Date(); 
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format1 = new SimpleDateFormat(pattern);
	%>
	<div>
		<h1>게시글 쓰기</h1>
	</div>
	<div>
		<form:form modelAttribute="board" method="post">
			<div>
				<h2>분류 : <form:select path="category" name="category">
					<form:option value="공지사항">공지사항</form:option>
					<form:option value="기타">기타</form:option>
				</form:select></h2>
				<h2>제목 : <form:input path="title" name="title" /></h2>
				<h3>게시일자 : <form:input path="date" name="date" value="<%=format1.format(date)%>" readonly="true" /></h3>
			</div>
			<div>
				<h4>내용</h4>
				<p><form:textarea path="content" name="content" rows="20" cols="100" /></p>
				<p><a href="list">목록으로</a><input type="submit" value="등록하기"></p>
			</div>
		</form:form>
	</div>

</body>
</html>