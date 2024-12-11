<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>성장일기 수정</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">성장일기 관리</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="home">홈</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="diarys">성장일기 관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="products">출산용품 관리</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-4">
        <h1 class="mb-4">성장일기 수정</h1>
        
        <form action="<c:url value='/diarys/update/${diary.id}' />" method="post">
            <div class="mb-3">
                <label for="today" class="form-label">일자</label>
                <input type="date" class="form-control" id="today" name="today" value="${diary.today}" required>
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
            <a href="diarys" class="btn btn-secondary">취소</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>