<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>출산용품 등록</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">프로젝트 이름</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="home">홈</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="emergencys">응급실 관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="products">출산용품 관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="growth-diary">성장일기</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="consultation">상담 요청</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="community">커뮤니티</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="profile">내 정보</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="p-5 mb-4 bg-light rounded-3">
            <h1 class="display-5 fw-bold">출산용품 등록</h1>
            <p class="col-md-8 fs-4">출산용품 정보를 입력하세요.</p>

            <form action="add" method="post">
                <div class="mb-3">
                    <label for="productName" class="form-label">용품 이름</label>
                    <input type="text" class="form-control" id="productName" name="productName" required>
                </div>
                <div class="mb-3">
                    <label for="useCategory" class="form-label">분류</label>
                    <input type="text" class="form-control" id="useCategory" name="useCategory" required>
                <div class="mb-3">
                    <label for="gradeCategory" class="form-label">시기</label>
                    <input type="text" class="form-control" id="gradeCategory" name="gradeCategory" required>
                </div>
                <div class="mb-3">
                    <label for="productPrice" class="form-label">가격 (원)</label>
                    <input type="number" class="form-control" id="productPrice" name="productPrice" required>
                </div>
                <div class="mb-3">
                    <label for="quantity" class="form-label">재고 수량</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" required>
                </div>
                <div class="mb-3">
                    <label for="acquisitionPath" class="form-label">취득 경로</label>
                    <input type="text" class="form-control" id="acquisitionPath" name="acquisitionPath" required> 
                </div>
                <div class="mb-3">
                    <label for="acquisitionMethod" class="form-label">취득 방법</label>
                    <input type="text" class="form-control" id="acquisitionMethod" name="acquisitionMethod" required> 
                </div>
                <button type="submit" class="btn btn-primary">등록</button>
                <a href="products" class="btn btn-secondary">취소</a>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
</body>
</html>