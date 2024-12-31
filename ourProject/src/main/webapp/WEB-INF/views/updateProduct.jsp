<%@ page session = "false" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>출산용품 수정</title>
</head>
<body>
	<%@ include file="header.jsp" %>

    <div class="container">
        <div class="p-5 mb-4 bg-light rounded-3">
            <h1 class="display-5 fw-bold">출산용품 수정</h1>
            <p class="col-md-8 fs-4">출산용품 수정할 정보를 입력하세요.</p>

            <form action="<c:url value='/products/update?id=${product.num}' />" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="productName" class="form-label">용품 이름</label>
                    <input type="text" class="form-control" id="productName" name="productName" value="${product.productName}" required>
                    
                </div>
                <div class="mb-3">
                    <label for="useCategory" class="form-label">분류</label>
                    <input type="text" class="form-control" id="useCategory" name="useCategory" value="${product.useCategory}" required>
                </div>
                <div class="mb-3">
                    <label for="gradeCategory" class="form-label">시기</label>
                    <input type="text" class="form-control" id="gradeCategory" name="gradeCategory" value="${product.useCategory}" required>
                </div>
                <div class="mb-3">
                    <label for="productPrice" class="form-label">가격 (원)</label>
                    <input type="number" class="form-control" id="productPrice" name="productPrice" value="${product.productPrice}" required>
                </div>
                <div class="mb-3">
                    <label for="quantity" class="form-label">재고 수량</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" value="${product.quantity}" required>
                </div>
                <div class="mb-3">
                    <label for="acquisitionPath" class="form-label">취득 경로</label>
                    <input type="text" class="form-control" id="acquisitionPath" name="acquisitionPath" value="${product.acquisitionPath}" required> 
                </div>
                <div class="mb-3">
                    <label for="acquisitionMethod" class="form-label">취득 방법</label>
                    <input type="text" class="form-control" id="acquisitionMethod" name="acquisitionMethod" value="${product.acquisitionMethod}" required> 
                </div>
                
                <c:if test="${not empty product.fileName}">
                    <img src="${pageContext.request.contextPath}/resources/images/${product.fileName}" alt="Product Image" class="img-fluid mb-2" style="max-height: 300px; width: auto;"/>
                </c:if>
                
                <button type="submit" class="btn btn-primary">수정 완료</button>
            	<a href="./" class="btn btn-secondary">취소</a>
                
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
</body>
</html>