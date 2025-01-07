<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
    <style>
        body {
            background-color: #fefcf8; /* 배경색 설정 */
        }
    </style>	
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container d-grid justify-content-center" style="padding:140px 0 50px 0;">
		<div>
			<h1>게시글 수정하기</h1>
		</div>
		<div>
			<form:form modelAttribute="board" method="post" class="form">
			    <table class="table-borderless" style="width:100%">
			        <!-- 분류 -->
			        <tr class="align-items-center d-flex justify-content-between">
			            <td class="d-flex">
			                <h4 class="col-form-label col-auto">분류 : </h4>
			                <form:input path="category" value="${board.category}" class="form-control" />
			            </td>
			        <!-- 게시일자 -->
			            <td class="d-flex">
			                <h4 class="col-form-label col-auto">게시일자 : </h4>
			                <form:input path="date" value="${board.date}" class="form-control" />
			            </td>
			        </tr>
			        <!-- 제목 -->
			        <tr class="align-items-center">
			            <td class="d-flex" colspan="2">
			                <h4 class="col-form-label col-auto">제목 : </h4>
			                <form:input path="title" value="${board.title}" class="form-control" />
			            </td>
			        </tr>
			    </table>
				<div class="mt-3">
					<h4>내용</h4>
					<p><form:textarea path="content" value="${board.content}" rows="20" cols="100" /></p>
					<p>
					<a href="list" class="btn btn-secondary">목록으로</a>
					<input type="submit" value="수정하기" class="btn btn-primary">
					<a href="<c:url value="/admin/delete?number=${board.number}"/>" class="btn btn-danger">삭제</a></p>
				</div>
			</form:form>
		</div>
	</div>
	
	<%@ include file="footer.jsp" %>

</body>
</html>