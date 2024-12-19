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

	<div>
		<h1>보드 수정하기</h1>
	</div>
	<div>
		<form:form modelAttribute="board" method="post">
			<div>
				<h2>분류 : <form:input path="category" value="${board.category}" /></h2>				
				<h2>제목 : <form:input path="title" value="${board.title}" /></h2>
				<h3>게시일자 :<form:input path="date" value="${board.date}" /></h3>
			</div>
			<div>
				<h4>내용</h4>
				<p><form:textarea path="content" value="${board.content}" rows="20" cols="100" /></p>
				<p><a href="../board/list">목록으로</a><input type="submit" value="수정하기"><a href="/ourProject/admin/delete?number=${board.number}">삭제</a></p>
			</div>
		</form:form>
	</div>

</body>
</html>