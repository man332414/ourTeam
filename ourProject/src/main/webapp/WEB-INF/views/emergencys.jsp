<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <title>응급실 관리</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#">프로젝트 이름</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">홈</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="emergencys">응급실 관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="products">출산용품 관리</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="diary">성장일기</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="consultation">상담 요청</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="community">커뮤니티</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="profile">내 정보</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold">응급실 관리</h1>
                <p class="col-md-8 fs-4">응급실 목록을 확인하세요.</p>
                <a href="emergencys/add" class="btn btn-primary">병원 등록</a>
                <a href="emergencys/addapi" class="btn btn-secondary">병원 등록 API</a>
                <a href="https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?ServiceKey=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D&pageNo=1&numOfRows=10" class="btn btn-info">병원 API XML -> JSON</a>
                
                <form action="convert" method="post" class="mt-3">
                    <label>병원 API XML -> JSON (POST)</label>
                    <input type="submit" class="btn btn-success" value="실행" />
                </form>

                <form action="http://localhost:8080/convert" method="post" class="mt-2">
                    <label>병원 API XML -> JSON (POST)</label>
                    <input type="submit" class="btn btn-success" value="실행 (로컬)" />
                </form>

                <form action="convert" method="get" class="mt-3">
                    <fieldset>
                        <legend>병원 API 폼</legend>
                        <label>병원 API XML -> JSON
                            <input name="xml" class="form-control" />
                        </label>
                        <button class="btn btn-primary mt-2">병원 API 실행</button>
                    </fieldset>
                </form>
            </div>
        </div>

        <div class="row">
            <c:forEach items="${emergencylist}" var="room">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${room.hosName}</h5>
                            <p class="card-text">${room.hosaddr}<br>${room.hosaddr}</p>
                            <p>거리: ${room.distance} km | 이동시간: ${room.travelTime} 분</p>
                            <p>병상수: ${room.numOfBad}개</p>
                            <p>소아과: 
                                <c:choose>
                                    <c:when test="${room.pediatrics}">
                                        <b>있습니다</b>
                                    </c:when>
                                    <c:otherwise>
                                        <b>없습니다</b>
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <p>산부인과:  
                                <c:choose>
                                    <c:when test="${room.obstetricsAndGynecology}">
                                        <b>있습니다</b>
                                    </c:when>
                                    <c:otherwise>
                                        <b>없습니다</b>
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <a href="<c:url value="/emergencys/room?id=${room.number}" />" class="btn btn-secondary">상세정보 &raquo;</a>
                            <a href="javascript:void(0);" 
                            onclick="window.open('https://map.kakao.com/link/to/${room.hosName},${latitude},${longitude}/from/집,35.232058,128.583789', 
                            		'_blank', 'width=981, height=650')">
							        목적지 지도보기 </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        
        <hr>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
</body>
</html>