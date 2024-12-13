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
        #map {
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

        function fetchCoordinates() {
            var address = document.getElementById("addressInput").value;
            console.log("100.입력 주소: ", address); // 주소 출력
          
            var encodedAddress = encodeURIComponent(address);
            console.log("200.encodedAddress: ", encodedAddress); // 주소 출력
            
            fetch(`http://localhost:8080/ourProject/getCoordinates?address=${encodedAddress}`)
                .then(response => {
            		console.log("310.response: ", response,response.ok);
                	
                    if (!response.ok) {
                        throw new Error('네트워크 응답이 정상적이지 않습니다.'+response.ok); // 좀 더 구체적인 오류 메시지
                    }
                    return response.json();
                })
                .then(data => {
                    if (data.latitude && data.longitude) {
                        showMap(data.latitude, data.longitude);
                    } else {
                    	showMap(data.latitude, data.longitude);
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
    <button onclick="fetchCoordinates()">검색</button>
    <div id="maptest"></div> <!-- 지도를 표시할 div -->
    
</body>
</html>