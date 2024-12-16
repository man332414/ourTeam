<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>임산부 정보 취합 프로젝트</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> <!-- Bootstrap CSS -->
    <style>
        /* 지도 스타일 설정 */
        #map {
            width: 100%;
            height: 350px;
        }
        /* 고정된 메뉴를 위한 여백 설정 */
        body {
            padding-top: 70px; /* 메뉴 높이만큼 여백 추가 */
        }
    </style>
</head>
<body>
    <header class="bg-light py-3 fixed-top">
        <div class="container text-center">
            <h1>임산부 정보 취합 프로젝트</h1>
            <nav class="nav justify-content-center">
                <a class="nav-link" href="readMembers">회원 관리</a>
                <a class="nav-link" href="admin/board">게시판</a>
                <a class="nav-link" href="calendar">일정 관리</a>
                <a class="nav-link" href="emergencys">응급실 관리</a>
                <a class="nav-link" href="products">출산/육아용품 관리</a>
                <a class="nav-link" href="diarys">성장일기</a>
                <a class="nav-link" href="map">지도</a>
                <a class="nav-link" href="home">관리자페이지</a>
            </nav>
        </div>
    </header>

    <main class="container mt-4">
        <section id="welcome" class="text-center mb-4">
            <h2>환영합니다!</h2>
            <p>임산부를 위한 다양한 정보를 제공하여 지원받을 수 있도록 돕습니다.</p>
        </section>

        <section id="features" class="mb-4">
            <h2 class="text-center">주요 기능</h2>
            <div class="row text-center">
                <div class="col-md-4">
                    <button class="btn btn-primary btn-lg" onclick="location.href='emergencys'">응급실 찾기</button>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-primary btn-lg" onclick="location.href='products'">출산용품 관리</button>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-primary btn-lg" onclick="location.href='diarys'">성장일기 작성</button>
                </div>
            </div>
        </section>

        <section id="map-section" class="mb-4">
            <h2 class="text-center">지도</h2>
            <div id="map"></div>
        </section>

        <section id="announcements" class="mb-4">
            <h2 class="text-center">공지사항</h2>
            <ul class="list-group">
                <li class="list-group-item">다음 주에 건강 세미나가 열립니다.</li>
                <li class="list-group-item">임산부를 위한 무료 상담 서비스가 시작됩니다.</li>
            </ul>
        </section>

        <section id="recommended-content" class="mb-4">
            <h2 class="text-center">추천 콘텐츠</h2>
            <ul class="list-group">
                <li class="list-group-item"><a href="#blog1">임신 초기 건강 관리</a></li>
                <li class="list-group-item"><a href="#blog2">영양 가이드</a></li>
                <li class="list-group-item"><a href="#blog3">운동과 스트레스 관리</a></li>
                <li class="list-group-item"><a href="./indexy.jsp">indexy</a></li>
                <li class="list-group-item"><a href="./indexrt.jsp">indexrt</a></li>
            </ul>
        </section>
    </main>

    <footer class="bg-light text-center py-3">
        <p>연락처: info@example.com</p>
        <p><a href="#terms">이용 약관</a> | <a href="#privacy">개인정보 처리방침</a></p>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
    
    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6"></script>
    <script>
        // 지도를 표시할 div 요소를 가져옵니다.
        var mapContainer = document.getElementById('map');

        // 현재 위치를 가져옵니다.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                var lat = position.coords.latitude; // 위도
                var lng = position.coords.longitude; // 경도

                // 지도 옵션 설정
                var mapOption = { 
                    center: new kakao.maps.LatLng(35.23209, 128.5838), // 현재 위치를 중심 좌표로 설정
                    level: 3 // 지도의 확대 레벨
                };

                
                console.log("현재 위치 - 위도:", lat, "경도:", lng); // 올바른 console.log 사용

                // 지도를 생성합니다.
                var map = new kakao.maps.Map(mapContainer, mapOption);
            }, function(error) {
                console.error('Geolocation error:', error);
                // 기본 좌표 설정 (예: 서울)
                var mapOption = { 
                    center: new kakao.maps.LatLng(37.5665, 126.978), // 서울의 좌표
                    level: 3 // 지도의 확대 레벨
                };
                var map = new kakao.maps.Map(mapContainer, mapOption);
            });
        } else {
            // Geolocation을 지원하지 않을 경우 기본 좌표 설정
            var mapOption = { 
                center: new kakao.maps.LatLng(37.5665, 126.978), // 서울의 좌표
                level: 3 // 지도의 확대 레벨
            };
            var map = new kakao.maps.Map(mapContainer, mapOption);
        }
    </script>
</body>
</html>