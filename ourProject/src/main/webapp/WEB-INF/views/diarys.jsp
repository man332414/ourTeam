<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>성장일기 목록</title>
    <!-- jQuery 라이브러리 로드 -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">성장일기 관리</a>
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
                    <!-- 추가 네비게이션 항목 -->
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="p-5 mb-4 bg-light rounded-3">
            <h1 class="display-5 fw-bold">성장일기 목록</h1>
            <p class="col-md-8 fs-4">작성된 성장일기를 확인하세요.</p>
            <a href="diarys/add" class="btn btn-primary">일기 작성하기</a>

            <div class="row mt-4">
                <c:if test="${not empty diarylist}">
                    <c:forEach items="${diarylist}" var="diary">
                        <div class="col-md-4 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <h5 type="datetime-local" class="card-title">${diary.today}</h5>
                                    <p class="card-text">날씨: ${diary.weather}<br>기분: ${diary.myMood}</p>
                                    <p>작성일: ${diary.today}</p>
                                    <a href="<c:url value='/diarys/${diary.id}' />" class="btn btn-secondary">상세보기 &raquo;</a>
                                    <a href="<c:url value='/diarys/edit/${diary.id}' />" class="btn btn-warning">수정</a>
							   <%-- <a href="<c:url value='/diarys/delete/${diary.id}' />" class="btn btn-danger">삭제</a> --%>
                                    <button class="btn btn-danger delete-button" data-id="${diary.id}">삭제</button> <!-- Ajax 삭제 버튼 -->
                                </div>
                            </div>
                        </div>
                        
                         <!-- 콘솔에 diary 정보를 출력 -->
                        <script>
                            console.log("Diary ID: ${diary.id}, Title: ${diary.today}, Weather: ${diary.weather}, Mood: ${diary.myMood}");
                        </script>
                        
                    </c:forEach>
                </c:if>
                <c:if test="${empty diarylist}">
                    <p>작성된 성장일기가 없습니다.</p>
                </c:if>
            </div>

            <hr>
        </div>
    </div>
	
	<script>
	$(document).ready(function() {
        $('.delete-button').click(function() {
            console.log('Deleting diary with ID: ' + $(this).data('id')); // 삭제할 ID 출력
            var diaryId = $(this).data('id');
            console.log('Deleting diary with ID: ' + diaryId); // 삭제할 ID 출력
            if (confirm('정말로 삭제하시겠습니까?')) {
                $.ajax({
                    url: 'diarys/delete/' + diaryId,
                    type: 'DELETE',
                    success: function(result) {
                        alert('성장일기가 삭제되었습니다.');
                        location.reload(); // 페이지 새로 고침
                    },
                    error: function(xhr, status, error) {
                        console.error('삭제에 실패했습니다: ' + error); // 에러 메시지 출력
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