<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>카카오 맵 예제</title>
    <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6&libraries=services"></script>
    <style>
        #maptest {
            width: 100%; /* 원하는 너비 */
            height: 400px; /* 원하는 높이 */
        }
    </style>
    <script>
        function showMap(latitude, longitude) {
            var mapContainer = document.getElementById('maptest'),
                mapOption = { 
                    center: new kakao.maps.LatLng(latitude, longitude),
                    level: 3 
                };

            var maptest = new kakao.maps.Map(mapContainer, mapOption); 
        }

        function getCoordinates() {
            var address = document.getElementById("addressInput").value;
            // encodeURIComponent가 JavaScript 내에서 호출됩니다.
            fetch(`http://localhost:8080/ourProject/getCoordinates?address=${encodeURIComponent(address)}`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    if (data.latitude && data.longitude) {
                        showMap(data.latitude, data.longitude);
                    } else {
                        alert('좌표를 찾을 수 없습니다.');
                    }
                })
                .catch(error => {
                    alert('주소 검색 실패: ' + error.message);
                });
        }
    </script>
</head>
<body>
    <h1>지도 탐색기</h1>
    <input type="text" id="addressInput" placeholder="주소를 입력하세요">
    <button onclick="getCoordinates()">검색</button>
    <div id="maptest"></div> <!-- 지도를 표시할 div -->
</body>
</html>