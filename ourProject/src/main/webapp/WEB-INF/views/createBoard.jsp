<%@ page session = "false" %>
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
	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa; /* 배경색 설정 */
        }
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<% 
		Date date = new Date(); 
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format1 = new SimpleDateFormat(pattern);
	%>
	<div class="container d-grid justify-content-center" style="padding:140px 0 80px 0;">
		<div>
			<h1>게시글 쓰기</h1>
		</div>
		<div>
			<form:form modelAttribute="board" method="post">
				<div>
					<p>분류 : <form:select path="category" name="category">
						<form:option value="공지사항">공지사항</form:option>
						<form:option value="기타">기타</form:option>
					</form:select></p>
					<p>제목 : <form:input path="title" name="title" /></p>
					<p>게시일자 : <form:input path="date" name="date" value="<%=format1.format(date)%>" readonly="true" /></p>
				</div>
				<div>
					<h4>내용</h4>
					<p><form:textarea path="content" name="content" rows="20" cols="100" /></p>
					<p>
						<a href="list" class="btn btn-secondary">목록으로</a>
						<input type="submit" value="등록하기" class="btn btn-primary">
					</p>
				</div>
			</form:form>
		</div>
	</div>
	<%@ include file="footer.jsp" %>

</body>
</html>