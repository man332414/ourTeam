<%@ page session = "false" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>출산용품 관리</title>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="container justify-content-center" style="padding:140px 0 30px 0;">
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
                                    <h5 class="card-title d-flex justify-content-between">
									    <span>${product.productName}</span>
									    <span>Num: ${product.num}</span>
									</h5>
                                    <p class="card-text">분류: ${product.useCategory}<br>가격: ${product.productPrice} 원</p>
                                    <p>재고 수량: ${product.quantity}개</p>
                                    <p>취득 경로: ${product.acquisitionPath}</p>
                                    <p>취득 방법: ${product.acquisitionMethod}</p>
                                    
                                    <!-- 이미지 표시 -->
                                    <c:if test="${not empty product.fileName}">
                                        <img src="${pageContext.request.contextPath}/resources/images/${product.fileName}" alt="Product Image" class="img-fluid mb-2" style="max-height: 200px; width: auto;"/>
                                    </c:if>
                                    
                                    <a href="<c:url value='products/product?id=${product.num}' />" class="btn btn-secondary">상세정보 &raquo;</a>
                                    <a href="<c:url value='/products/update?id=${product.num}' />" class="btn btn-warning">수정</a>
                                    <button class="btn btn-danger delete-button" data-id="${product.num}">삭제</button> <!-- Ajax 삭제 버튼 -->
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
	
	<script>
	$(document).ready(function() {
        $('.delete-button').click(function() {
            var productNum = $(this).data('id');
            if (confirm('정말로 삭제하시겠습니까?')) {
            	console.log("productNum : "+productNum);
                $.ajax({
                    url: 'products/delete/' + productNum,
                    type: 'DELETE',
                    success: function(result) {
                        alert('용품이 삭제되었습니다.');
                        location.reload(); // 페이지 새로 고침
                    },
                    error: function(xhr, status, error) {
                        console.error('삭제에 실패했습니다: ' + error);
                        alert('삭제에 실패했습니다: ' + error);
                    }
                });
            }
        });
    });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
</body>
</html>