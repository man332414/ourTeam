<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<div>
		<h1>게시판 기능입니다.</h1>
	</div>
	
	<div>
		<table>
			<tr>
				<th>순번</th><th>분류</th><th>제목</th><th>게시일자</th><th>비고</th>
			</tr>
			<tr>
				<td></td><td>${board.getCategory()}</td><td>${board.getSubject()}</td><td>${board.getDate()}</td><td></td>
			</tr>
		</table>
	</div>
</body>
</html>