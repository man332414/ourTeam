<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int numberOfRows;
	int currentPage;
%>   
<!DOCTYPE html>
<html lang="ko">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
    <meta charset="UTF-8">
<!-- <script type="text/javascript" src="/ourProject/resources/js/searchFunction.js"></script> -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>임산부 정보 취합 프로젝트</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        #map-section {
   		 text-align: center;
		}
        
        /* 지도 스타일 설정 */
        #map {
            width: 75%;
            height: 450px;
            display: inline-block; /* 또는 원하는 너비를 설정 */
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
                <a class="nav-link" href="board/list">게시판</a>
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

         <section id="board" class="mb-4">
            <h2 class="text-center">임산부지원게시판</h2>
            <form action="searching">
                <%
                    String searchFor;
                    if (request.getAttribute("searchFor") == null) {
                        searchFor = "";							
                    } else {
                        searchFor = (String) request.getAttribute("searchFor"); 
                    }
                %>
                검색하기 : <input type="text" id="searchBox" name="searchFor" value="<%= searchFor %>">
                <input type="submit" value="검색">
            </form>
            <form method="get" action="">
                <label for="numberOfRows">페이지당 항목 수:</label>
                <select name="numberOfRows" id="numberOfRows" onchange="this.form.submit()">
                    <option value="10" <%= numberOfRows == 10 ? "selected" : "" %>>선택</option>
                    <option value="10" <%= numberOfRows == 10 ? "selected" : "" %>>10</option>
                    <option value="20" <%= numberOfRows == 20 ? "selected" : "" %>>20</option>
                    <option value="50" <%= numberOfRows == 50 ? "selected" : "" %>>50</option>
                    <option value="100" <%= numberOfRows == 100 ? "selected" : "" %>>100</option>
                </select>
            </form>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>순번</th>
                        <th>분류</th>
                        <th>제목</th>
                        <th>게시일자</th>
                        <th>비고</th>
                    </tr>
                </thead>
                <tbody id="resultBody">
                    <c:forEach var="board" items="${boards}">
                        <tr>
                            <td><a href="content?number=${board.number}">${board.number}</a></td>
                            <td><a href="content?number=${board.number}">${board.category}</a></td>
                            <td><a href="content?number=${board.number}">${board.title}</a></td>
                            <td><a href="content?number=${board.number}">${board.date}</a></td>
                            <td><a href="content?number=${board.number}">보기</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <% int totalPage = 0; %>
            <div id="pages" class="text-center">
                
                <a href="board/list">더보기</a>	
            </div>
        </section>
         
        <section id="recommended-content" class="mb-4">
            <h2 class="text-center">추천 콘텐츠</h2>
            <ul class="list-group">
                <li class="list-group-item"><a href="#blog1">임신 초기 건강 관리</a></li>
                <li class="list-group-item"><a href="#blog2">영양 가이드</a></li>
                <li class="list-group-item"><a href="#blog3">운동과 스트레스 관리</a></li>
                <li class="list-group-item"><a href="./indexy.jsp">index-test</a></li>
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
               // lat = 35.232019; // 위도
               // lng = 128.583789; // 경도
               
                // 지도 옵션 설정
                var mapOption = { 
                    center: new kakao.maps.LatLng(35.232019, 128.583789), // 현재 위치를 중심 좌표로 설정
                    level: 3 // 지도의 확대 레벨
                };

                
                console.log("현재 위치 - 위도:", lat, "경도:", lng); // 올바른 console.log 사용

                // 지도를 생성합니다.
                var map = new kakao.maps.Map(mapContainer, mapOption);
                // 마커와 인포윈도우 생성
                var markerPosition  = new kakao.maps.LatLng(lat, lng); 
                var marker = new kakao.maps.Marker({
                    position: markerPosition
                });

                marker.setMap(map); // 마커를 지도에 추가

                // 인포윈도우 내용 설정
                var infowindow = new kakao.maps.InfoWindow({
                    content: '<div style="padding:5px;">현재 위치</div>'
                });

                infowindow.open(map, marker); // 인포윈도우를 마커 위에 표시
                
            }, function(error) {
                console.error('Geolocation error:', error);
                // 기본 좌표 설정 (예: 양덕)
                var mapOption = { 
                    center: new kakao.maps.LatLng(35.232019, 128.583789), // 양덕동의 좌표
                    level: 3 // 지도의 확대 레벨
                };
                var map = new kakao.maps.Map(mapContainer, mapOption);
            });
        } else {
            // Geolocation을 지원하지 않을 경우 기본 좌표 설정
            var mapOption = { 
                center: new kakao.maps.LatLng(35.232019, 128.583789), // 양덕동의 좌표
                level: 3 // 지도의 확대 레벨
            };
            var map = new kakao.maps.Map(mapContainer, mapOption);
        }
    </script>
</body>

</html>