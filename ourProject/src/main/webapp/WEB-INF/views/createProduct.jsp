<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>출산용품 등록</title>
</head>
<body>
	<%@ include file="header.jsp" %>

    <div class="container" style="padding:140px 0 30px 0;">
        <div class="p-5 mb-4 bg-light rounded-3">
            <h1 class="display-5 fw-bold">출산용품 등록</h1>
            <p class="col-md-8 fs-4">출산용품 정보를 입력하세요.</p>

            <form action="add" method="post" class="mt-4" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="productName" class="form-label">용품 이름</label>
                    <input type="text" class="form-control" id="productName" name="productName" required>
                </div>
                <div class="mb-3">
                    <label for="useCategory" class="form-label">분류</label>
                    <input type="text" class="form-control" id="useCategory" name="useCategory" required>
                </div>
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
                <div class="mb-3">
			        <label for="listImage" class="form-label">사진 업로드</label>
			        <input type="file" class="form-control" id="listImage" name="listImage" accept="image/*">
		   		</div>
                
                <button type="submit" class="btn btn-primary">등록</button>
                <a href="../products" class="btn btn-secondary">취소</a>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
	<%@ include file="footer.jsp" %>
</body>
</html>