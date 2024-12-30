<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카카오맵 거리 및 이동시간 계산</title>
    <script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6&libraries=services"></script>
    <style>
        #map {
            width: 100%;
            height: 400px;
        }
    </style>
</head>
<body>
    <div id="map"></div>
    <div id="result"></div>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var mapContainer = document.getElementById('map');
            var mapOption = {
                center: new kakao.maps.LatLng(35.232058, 128.583789), // 기본 위치
                level: 3
            };

            var map = new kakao.maps.Map(mapContainer, mapOption);

            // 현재 위치 가져오기
            function getCurrentLocation(callback) {
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(function(position) {
                        var lat = position.coords.latitude; // 위도
                        var lng = position.coords.longitude; // 경도
                        callback(new kakao.maps.LatLng(lat, lng));
                    }, function() {
                        alert('현재 위치를 가져올 수 없습니다. 위치 권한을 확인하세요.');
                    });
                } else {
                    alert('이 브라우저는 Geolocation을 지원하지 않습니다.');
                }
            }

            // 주소를 좌표로 변환하는 함수
            function getCoordinatesFromAddress(address, callback) {
                var geocoder = new kakao.maps.services.Geocoder();
                geocoder.addressSearch(address, function(result, status) {
                    if (status === kakao.maps.services.Status.OK) {
                        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
                        callback(coords);
                    } else {
                        alert('주소를 찾을 수 없습니다. 올바른 주소를 입력했는지 확인하세요.');
                    }
                });
            }

            // 경로를 계산하는 함수 (수정된 부분)
            function calculateRoute(start, end) {
                // 카카오 길찾기 API URL
                const serviceUrl = `https://apis.kakao.com/v2/geo/route.json?origin=${start.getLng()},${start.getLat()}&destination=${end.getLng()},${end.getLat()}`;
                const headers = {
                    Authorization: 'c90c1da07d750b4cb2f9958d594fae60' // 여기에 실제 REST API 키 입력
                };

                fetch(serviceUrl, { headers })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Network response was not ok');
                        }
                        return response.json();
                    })
                    .then(data => {
                        if (data.routes.length > 0) {
                            const distance = data.routes[0].distance; // 실제 거리
                            const duration = data.routes[0].duration; // 실제 시간
                            document.getElementById('result').innerHTML = 
                                '거리: ' + (distance / 1000).toFixed(2) + ' km<br>' + 
                                '이동 시간: ' + Math.floor(duration / 60) + ' 분 ' + (duration % 60) + ' 초';
                        } else {
                            alert('경로를 계산할 수 없습니다.');
                        }
                    })
                    .catch(error => console.error('오류:', error));
            }

            // 현재 위치와 B지점 주소 설정
            getCurrentLocation(function(start) {
                var address = '경남 창원시 마산회원구 3.15대로 732'; // 여기에 원하는 주소를 입력하세요

                getCoordinatesFromAddress(address, function(end) {
                    calculateRoute(start, end);
                });
            });
        });
    </script>
</body>
</html>