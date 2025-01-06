<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background-color: #fefcf8; /* 배경색 설정 */
        }
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container d-grid justify-content-center" style="padding:140px 0 100px 0;">
		<div>
			<h1>${board.title}</h1>
		</div>
		<div>
			<div>
				<h4>분류 : ${board.category}</h4>
				<h4>게시일자 : ${board.date}</h4>
			</div>
			<div>
				<h4>내용</h4>
				<p style="height:300px">${board.content}</p>
				<p>
					<a href="list" class="btn btn-secondary">목록으로</a>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="/ourProject/board/update?number=${board.number}" class="btn btn-primary">수정</a>
						<a href="/ourProject/board/delete?number=${board.number}" class="btn btn-danger">삭제</a>
					</sec:authorize>
				</p>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>

</body>
</html>