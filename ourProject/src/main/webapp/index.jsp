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
        width: 100%;
        height: 350px;
    }
</style>
</head>
<body>
	<h1>임산부 정보 취합 프로젝트</h1>
	<a href="emergencys">1. </a><br>
	<a href="emergencys">2. </a><br>
	<a href="emergencys">3. </a><br>
	<a href="emergencys">4.emergencys(응급실관리)</a><br>
	<a href="products">5.products(출산/육아용품관리)</a><br>
	<a href="diarys">6.diarys(성장일기)</a><br>
	<a href="map">9.지도</a><br>
	<a href="maptest">9t.maptest</a><br>
	9c0a4381f5a94e6cb0eef56dbcf98cb6
<div id="map"></div>

    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6"></script>
    <script>
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
            mapOption = { 
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption); 
    </script>

<div id="maptest"></div>

    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6"></script>
    <script>
        var mapContainer = document.getElementById('maptest'), // 지도를 표시할 div 
            mapOption = { 
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        var maptest = new kakao.maps.Map(mapContainer, mapOption); 
    </script>

	
</body>
</html>