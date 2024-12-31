<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<%@ include file="header.jsp" %>
	<div>
		<h1>글 하나 읽어오기</h1>
	</div>
	<div>
		<div>
			<h2>분류 : ${board.category}</h2>
			<h2>제목 : ${board.title}</h2>
			<h3>게시일자 : ${board.date}</h3>
		</div>
		<div>
			<h4>내용</h4>
			<p>${board.content}</p>
			<p><a href="list">목록으로</a><a href="/ourProject/board/update?number=${board.number}">수정</a><a href="/ourProject/board/delete?number=${board.number}">삭제</a></p>
		</div>
	</div>

</body>
</html>