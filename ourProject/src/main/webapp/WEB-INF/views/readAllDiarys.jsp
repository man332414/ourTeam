<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <title>성장일기 목록</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> 
    <style>
        body{
        	background-color:#fefcf8;
        }
    </style>
    
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container justify-content-center" style="padding:140px 0 30px 0;">
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
                                    <h5 class="card-title d-flex justify-content-between">
									    <span>${diary.today}</span>
									    <span>ID: ${diary.id}</span>
									</h5>
                                    <p class="card-text"><br>날씨: ${diary.weather}<br>기분: ${diary.myMood}</p>
                                    <p>작성일: ${diary.today}</p>
                                    
                                    
                                    <!-- 이미지 표시 -->
                                    <c:if test="${not empty diary.fileName}">
                                        <img src="${pageContext.request.contextPath}/resources/images/${diary.fileName}" alt="Diary Image" class="img-fluid mb-2" style="max-height: 200px; width: auto;"/>
                                    </c:if>

                                    <a href="<c:url value='/diarys/${diary.id}' />" class="btn btn-secondary">상세보기 &raquo;</a>
                                    <a href="<c:url value='/diarys/update?id=${diary.id}' />" class="btn btn-warning">수정</a>
                                    <button class="btn btn-danger delete-button" data-id="${diary.id}">삭제</button> <!-- Ajax 삭제 버튼 -->
                                </div>
                            </div>
                        </div>                        
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
            var diaryId = $(this).data('id');
            if (confirm('정말로 삭제하시겠습니까?')) {
            	console.log("diaryId : "+diaryId);
                $.ajax({
                    url: 'diarys/delete/' + diaryId,
                    type: 'DELETE',
                    success: function(result) {
                        alert('성장일기가 삭제되었습니다.');
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
	<%@ include file="footer.jsp" %>
</body>
</html>