<%@ page session = "false" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
    <title>성장일기 상세보기</title>
</head>
<body>
	<%@ include file="header.jsp" %>

	<div class="container justify-content-center" style="padding:140px 0 30px 0;">
        <h1 class="mb-4">성장일기 상세보기</h1>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${diary.today}</h5>
                <p class="card-text">날씨: ${diary.weather}</p>
                <p class="card-text">기분: ${diary.myMood}</p>
                <p class="card-text">내용: ${diary.diaryText}</p>

                <c:if test="${not empty diary.fileName}">
                    <img src="${pageContext.request.contextPath}/resources/images/${diary.fileName}" alt="Diary Image" class="img-fluid mb-2" style="max-height: 300px; width: auto;"/>
                </c:if>

                <a href="<c:url value='/diarys/update?id=${diary.id}' />" class="btn btn-warning">수정</a>
                <button class="btn btn-danger delete-button" data-id="${diary.id}">삭제</button>
                <a href="./?userId=<%=member.getUserId()%>" class="btn btn-secondary">목록으로 돌아가기</a>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
    $(document).ready(function() {
        $('.delete-button').click(function() {
            var diaryId = $(this).data('id');
            if (confirm('정말로 삭제하시겠습니까?')) {
                $.ajax({
                    url: 'diarys/delete/' + diaryId,
                    type: 'DELETE',
                    success: function(result) {
                        alert('성장일기가 삭제되었습니다.');
                        window.location.href = 'diarys'; // 목록 페이지로 리다이렉트
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
	<%@ include file="footer.jsp" %>
</body>
</html>