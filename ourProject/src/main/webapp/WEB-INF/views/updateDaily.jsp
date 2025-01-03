<%@ page session = "false" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
    <title>성장일기 수정</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="container justify-content-center" style="padding:140px 0 30px 0;">
        <h1 class="mb-4">성장일기 수정</h1>
        
        <form action="<c:url value='/diarys/update?id=${diary.id}' />" method="post">
            <div class="mb-3">
                <label for="today" class="form-label">일자</label>
                <input type="datetime-local" class="form-control" id="today" name="today" value="${diary.today}" required>
            </div>
            <div class="mb-3">
                <label for="weather" class="form-label">날씨</label>
                <input type="text" class="form-control" id="weather" name="weather" value="${diary.weather}" required>
            </div>
            <div class="mb-3">
                <label for="myMood" class="form-label">기분</label>
                <input type="text" class="form-control" id="myMood" name="myMood" value="${diary.myMood}" required>
            </div>
            <div class="mb-3">
                <label for="diaryText" class="form-label">내용</label>
                <textarea class="form-control" id="diaryText" name="diaryText" rows="4" required>${diary.diaryText}</textarea>
            </div>
            <button type="submit" class="btn btn-primary">수정 완료</button>
            <a href="./?userId<%=member.getUserId() %>" class="btn btn-secondary">취소</a>
        </form>
    </div>

	<%@ include file="footer.jsp" %>
</body>
</html>