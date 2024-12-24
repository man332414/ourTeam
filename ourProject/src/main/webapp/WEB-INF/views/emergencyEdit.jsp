<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>병원 수정</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">병원 관리</a>
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
        <h1 class="mb-4">병원 수정</h1>

        <div class="card">
            <div class="card-body" width="500px">
                <form action="<c:url value='/emergencys/update?number=${room.number}' />" method="post">
                    <div class="mb-3">
                        <label for="hosName" class="form-label">${room.number} 병원 이름 </label>
                        <input type="text" class="form-control" id="hosName" name="hosName" value="${room.hosName}" required>
                    </div>
                    <div class="mb-3">
                        <label for="hosaddr" class="form-label">병원 주소</label>
                        <input type="text" class="form-control" id="hosaddr" name="hosaddr" value="${room.hosaddr}" required>
                    </div>
                    <div class="mb-3">
                        <label for="distance" class="form-label">거리 (km)</label>
                        <input type="number" step="0.1" class="form-control" id="distance" name="distance" value="${room.distance}" required>
                    </div>
                    <div class="mb-3">
                        <label for="travelTime" class="form-label">이동시간 (분)</label>
                        <input type="number" class="form-control" id="travelTime" name="travelTime" value="${room.travelTime}" >
                    </div>
                    <div class="mb-3">
                        <label for="numOfBad" class="form-label">병상수</label>
                        <input type="number" class="form-control" id="numOfBad" name="numOfBad" value="${room.numOfBad}" >
                    </div>
                    <div class="mb-3">
                        <label for="pediatrics" class="form-label">소아과</label>
                        <select class="form-control" id="pediatrics" name="pediatrics" required>
                            <option value="true" ${room.pediatrics ? 'selected' : ''}>있습니다</option>
                            <option value="false" ${!room.pediatrics ? 'selected' : ''}>없습니다</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="obstetricsAndGynecology" class="form-label">산부인과</label>
                        <select class="form-control" id="obstetricsAndGynecology" name="obstetricsAndGynecology" required>
                            <option value="true" ${room.obstetricsAndGynecology ? 'selected' : ''}>있습니다</option>
                            <option value="false" ${!room.obstetricsAndGynecology ? 'selected' : ''}>없습니다</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">수정 완료</button>
                    <a href="./" class="btn btn-secondary">취소</a>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>