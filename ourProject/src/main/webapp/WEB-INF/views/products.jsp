<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>출산용품 관리</title>
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
            <h1 class="display-5 fw-bold">출산용품 관리</h1>
            <p class="col-md-8 fs-4">출산용품 목록을 확인하세요.</p>
            <a href="products/add" class="btn btn-primary">용품 등록</a>

            <div class="row mt-4">
                <c:if test="${not empty productlist}">
                    <c:forEach items="${productlist}" var="product">
                        <div class="col-md-4 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">${product.productName}</h5>
                                    <p class="card-text">분류: ${product.useCategory}<br>가격: ${product.productPrice} 원</p>
                                    <p>재고 수량: ${product.quantity}개</p>
                                    <p>취득 경로: ${product.acquisitionPath}</p>
                                    <p>취득 방법: ${product.acquisitionMethod}</p>
                                    <a href="<c:url value='products/product?id=${product.num}' />" class="btn btn-secondary">상세정보 &raquo;</a>
                                    
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${empty productlist}">
                    <p>출산용품이 없습니다.</p>
                </c:if>
            </div>

            <hr>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
</body>
</html>