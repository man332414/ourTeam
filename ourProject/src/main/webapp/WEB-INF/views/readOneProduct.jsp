<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>출산용품 상세정보</title>
</head>
<body>
<!--     <nav class="navbar navbar-expand-lg navbar-light bg-light"> -->
<!--         <div class="container"> -->
<!--             <a class="navbar-brand" href="#">프로젝트 이름</a> -->
<!--             <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> -->
<!--                 <span class="navbar-toggler-icon"></span> -->
<!--             </button> -->
<!--             <div class="collapse navbar-collapse" id="navbarNav"> -->
<!--                 <ul class="navbar-nav"> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="home">홈</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="emergencys">응급실 관리</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="products">출산용품 관리</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="growth-diary">성장일기</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="consultation">상담 요청</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="community">커뮤니티</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="profile">내 정보</a> -->
<!--                     </li> -->
<!--                 </ul> -->
<!--             </div> -->
<!--         </div> -->
<!--     </nav> -->
	<%@ include file="header.jsp" %>

    <div class="container">
        <div class="p-5 mb-4 bg-light rounded-3">
            <h1 class="display-5 fw-bold">출산용품 상세정보</h1>
            <c:if test="${not empty product}">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">${product.productName}</h5>
                        <p class="card-text">분류: ${product.useCategory}</p>
                        <p class="card-text">가격: ${product.productPrice} 원</p>
                        <p class="card-text">재고 수량: ${product.quantity}개</p>
                        <p class="card-text">상세 설명: ${product.acquisitionPath}</p>
                        <p class="card-text">구매 방법: ${product.acquisitionMethod}</p>
                        <c:if test="${not empty product.fileName}">
		                    <img src="${pageContext.request.contextPath}/resources/images/${product.fileName}" alt="Product Image" class="img-fluid mb-2" style="max-height: 300px; width: auto;"/>
		                </c:if>
                        <a href="../products" class="btn btn-primary">목록으로 돌아가기</a>
                    </div>
                </div>
            </c:if>
            <c:if test="${empty product}">
                <p>해당 출산용품의 상세정보가 없습니다.</p>
                <a href="../products" class="btn btn-primary">목록으로 돌아가기</a>
            </c:if>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
</body>
</html>