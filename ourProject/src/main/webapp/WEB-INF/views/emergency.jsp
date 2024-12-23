<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>병원관리 상세보기</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">병원관리 상세보기</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
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
        <h1 class="mb-4">성장일기 상세보기</h1>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${room.hosName}</h5>
                <p class="card-text">${room.hosaddr}<br></p>
                <p class="card-text">거리: ${room.distance} km | 이동시간: ${room.travelTime} 분</p>
                <p class="card-text">병상수: ${room.numOfBad}개</p>
                <p class="card-text">소아과: 
                    <c:choose>
                        <c:when test="${room.pediatrics}">
                            <b>있습니다</b>
                        </c:when>
                        <c:otherwise>
                            <b>없습니다</b>
                        </c:otherwise>
                    </c:choose>
                </p>
                <p class="card-text">산부인과:  
                    <c:choose>
                        <c:when test="${room.obstetricsAndGynecology}">
                            <b>있습니다</b>
                        </c:when>
                        <c:otherwise>
                            <b>없습니다</b>
                        </c:otherwise>
                    </c:choose>
                </p>
                
                <c:if test="${not empty room.hosaddr}">
                    <img src="${pageContext.request.contextPath}/resources/images/${room.hosaddr}" alt="Diary Image" class="img-fluid mb-2" style="max-height: 300px; width: auto;"/>
                </c:if>

                <a href="<c:url value='/emergencysy/update?number=${room.number}' />" class="btn btn-warning">수정</a>
                <button class="btn btn-danger delete-button" data-id="${room.number}">삭제</button>
                <a href="./" class="btn btn-secondary">목록으로 돌아가기</a>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
    $(document).ready(function() {
        $('.delete-button').click(function() {
            var roomNum = $(this).data('number');
            if (confirm('정말로 삭제하시겠습니까?')) {
                $.ajax({
                    url: 'emergencysy/delete/' + roomNum,
                    type: 'DELETE',
                    success: function(result) {
                        alert('성장일기가 삭제되었습니다.');
                        window.location.href = 'emergencysy'; // 목록 페이지로 리다이렉트
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
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>