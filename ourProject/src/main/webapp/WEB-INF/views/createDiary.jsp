<%@ page session = "false" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta charset="UTF-8">
    <title>다이어리 입력</title>
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>

    <div class="container">
        <h1 class="mt-5">성장일기 작성하기</h1>
        <form action="add" method="post" class="mt-4" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="today" class="form-label">일자</label>
                <input type="datetime-local" class="form-control" id="today" name="today" required>
            </div>
            <div class="mb-3">
                <label for="weather" class="form-label">날씨</label>
                <input type="text" class="form-control" id="weather" name="weather" required>
            </div>
            <div class="mb-3">
                <label for="myMood" class="form-label">기분</label>
                <select class="form-select" id="myMood" name="myMood" required>
                    <option value="" disabled selected>선택하세요</option>
                    <option value="행복">행복</option>
                    <option value="슬픔">슬픔</option>
                    <option value="화남">화남</option>
                    <option value="화남">즐거움</option>
                    <option value="기타">기타</option>
                </select>
            </div>
            <div class="mb-3">
		        <label for="diaryImage" class="form-label">사진 업로드</label>
		        <input type="file" class="form-control" id="diaryImage" name="diaryImage" accept="image/*">
	   		</div>
            
            <div class="mb-3">
                <label for="diaryText" class="form-label">내용</label>
                <textarea class="form-control" id="diaryText" name="diaryText" rows="5" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">저장</button>
            <a href="../diarys" class="btn btn-secondary">취소</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>