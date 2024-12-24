<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임산부 정보 취합 프로젝트</title>
<style>
    /* 지도 스타일 설정 */
    #map {
        width: 80%;
        height: 450px;
    }
    /* 지도 스타일 설정 */
    #maptest {
        width: 80%;
        height: 450px;
    }
</style>
</head>
<body>
	<h1>임산부 정보 취합 프로젝트</h1>
	<a href="members">1.members(회원관리) </a><br>
	<a href="board">2.board(게시판) </a><br>
	<a href="calendar">3.calendar(일정관리) </a><br>
	<a href="emergencys">4.emergencys(응급실관리)</a><br>
	<a href="products">5.products(출산/육아용품관리)</a><br>
	<a href="diarys">6.diarys(성장일기)</a><br>
	<a href="map">9.지도</a><br>
	<a href="map1">9.지도에 표시</a><br>
	<a href="maptest">9t.maptest</a><br>
	<a href="mapdistim">10.map거리시간구하기</a><br>
	<a href="https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?ServiceKey=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D&pageNo=1&numOfRows=10" class="btn btn-info">11.병원 API XML -> JSON</a><br><br>
	9c0a4381f5a94e6cb0eef56dbcf98cb6
	<div id="map">map</div>

    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6"></script>
    <script>
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
            mapOption = { 
                center: new kakao.maps.LatLng(35.232058, 128.583789), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption); 
    </script>
	<br><br><br>
	<div id="maptest">maptest</div>

    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6"></script>
    <script>
        var mapContainer = document.getElementById('maptest'), // 지도를 표시할 div 
            mapOption = { 
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 5 // 지도의 확대 레벨
            };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var maptest = new kakao.maps.Map(mapContainer, mapOption); 
    </script>

	
</body>
</html>