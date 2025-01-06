<%@ page session = "false" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>출산용품 상세정보</title>
    <style>
        body{
        	background-color:#fefcf8;
        }
    </style>
</head>
<body>
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