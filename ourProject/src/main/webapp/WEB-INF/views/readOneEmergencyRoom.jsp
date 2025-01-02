<%@ page session = "false" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>병원관리 상세보기</title>
    <script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6&libraries=services">
    </script> <!-- 여기에 발급받은 API 키를 입력하세요 -->
      <style> 
         .card_main { 
             display: flex; 
             justify-content: space-between; 
             align-items: center; /* 수직 중앙 정렬 */ 
         } 
     </style> 
</head>
</head>
<body>
<!--     <nav class="navbar navbar-expand-lg navbar-light bg-light"> -->
<!--         <div class="container"> -->
<!--             <a class="navbar-brand" href="#">병원관리 상세보기</a> -->
<!--             <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> -->
<!--                 <span class="navbar-toggler-icon"></span> -->
<!--             </button> -->
<!--             <div class="collapse navbar-collapse" id="navbarNav"> -->
<!--                 <ul class="navbar-nav"> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="home">홈</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="diarys">성장일기 관리</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="products">출산용품 관리</a> -->
<!--                     </li> -->
<!--                 </ul> -->
<!--             </div> -->
<!--         </div> -->
<!--     </nav> -->
	<%@ include file="header.jsp" %>
<div class="card_main d-flex justify-content-between" >
    <div class="container mt-4">
        <h1 class="mb-4">응급실 상세보기</h1>

        <div class="card">
            <div class="card-body">
                <h5 class="card-title d-flex justify-content-between">
                             <span>${room.hosName}</span>
						     <span>ID: ${room.number}</span>
                            </h5><br>
                <p class="card-text">${room.hosaddr}<br></p>
                <p class="card-text">거리: ${room.distance} km | 이동시간: ${room.travelTime} 초</p>
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
                    <img src="${pageContext.request.contextPath}/resources/images/${room.hosaddr}" alt="${room.hosName}" class="img-fluid mb-2" style="max-height: 300px; width: auto;"/>
                </c:if>

                <a href="<c:url value='/emergencys/update?number=${room.number}' />" class="btn btn-warning">수정</a>
                <button class="btn btn-danger delete-button" data-id="${room.number}">삭제</button>
                <a href="./" class="btn btn-secondary">목록으로 돌아가기</a>
            </div>
        </div>
        
         <!-- 카카오 지도 표시를 위한 div 추가 -->
        <div id="map" style="width:100%;height:400px;"></div>

        <script>
        function initMap() {
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                mapOption = {
                    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };

            var map = new kakao.maps.Map(mapContainer, mapOption); // 지도 생성

            // 사용자 집 주소와 병원 주소에 대한 좌표 변환
            var geocoder = new kakao.maps.services.Geocoder();

            // 집 주소 (여기에 사용자의 집 주소를 입력하세요)
            var homeAddress = "경남 창원시 마산회원구 양덕북12길 113";
            var hospitalAddress = "${room.hosaddr}";

            // 집 주소 좌표 찾기
            geocoder.addressSearch(homeAddress, function(result, status) {
                if (status === kakao.maps.services.Status.OK) {
                    var homeCoords = new kakao.maps.LatLng(result[0].y, result[0].x);
                    map.setCenter(homeCoords); // 지도의 중심을 집 주소로 설정

                    // 병원 주소 좌표 찾기
                    geocoder.addressSearch(hospitalAddress, function(result, status) {
                        if (status === kakao.maps.services.Status.OK) {
                            var hospitalCoords = new kakao.maps.LatLng(result[0].y, result[0].x);

                         // 경로 표시
                            var linePath = [homeCoords, hospitalCoords];

                            var polyline = new kakao.maps.Polyline({
                                path: linePath,
                                strokeWeight: 5,
                                strokeColor: '#FF0000',
                                strokeOpacity: 0.7,
                                strokeStyle: 'solid'
                            });

                            polyline.setMap(map); // 지도에 경로 추가

                            // 마커 추가
                            var homeMarker = new kakao.maps.Marker({
                                position: homeCoords,
                                title: '집'
                            });
                            homeMarker.setMap(map);

                            var hospitalMarker = new kakao.maps.Marker({
                                position: hospitalCoords,
                                title: '병원'
                            });
                            hospitalMarker.setMap(map);

                            // 경로 안내를 위해 선을 지도에 추가
                            var bounds = new kakao.maps.LatLngBounds();
                            bounds.extend(homeCoords);
                            bounds.extend(hospitalCoords);
                            map.setBounds(bounds);
                               
                            
                        }
                    });
                }
            });
        }

        // 지도가 로드될 때 initMap 함수 호출
        kakao.maps.load(initMap);
        </script>
        
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