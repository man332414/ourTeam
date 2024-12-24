<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>지도 생성하기</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> <!-- Bootstrap CSS -->
    
</head>
<body>
	<%@ include file="header.jsp" %>

    <!-- 지도를 표시할 div 입니다 -->
    카카오맵입니다. map
    <div id="map" style="width:100%;height:450px;"></div>

    <script type="text/javascript" 
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6&libraries=services"></script>

    <script>
        // Kakao Maps API가 로드된 후 실행
        kakao.maps.load(function() {
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                mapOption = { 
                    center: new kakao.maps.LatLng(35.232058, 128.583789), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };

            // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
            var map = new kakao.maps.Map(mapContainer, mapOption); 
             
            // 주소-좌표 변환 객체를 생성합니다
            var geocoder = new kakao.maps.services.Geocoder();
            
            
            
            //데이터
            let url = "https://api.odcloud.kr/api/3077888/v1/uddi:444645a3-bc90-47fd-aa42-d717c93c464" +
                    "a_201705111713?page=1&perPage=10&serviceKey=COog2VpGwoKjJbuLbsotfPe9FOvhuC5Ax5" +
                    "OLcRW2sAPnLle8ggr2h8GA%2B977YsNjZZzkz4vKnJOzvcAqqbfBUA%3D%3D";
            //공공데이터 포털에서 api 키 받은 후에 사용하는 open APi
            

            $.getJSON(url, function (data) {
            	// 데이터 확인
                console.log(data);
            	
                for (let i = 0; i < data.currentCount; i++) {
                    let txt = "<tr><td>" + data
                        .data[i]
                        .번호 + "</td><td>" + data
                        .data[i]
                        .명칭 + "</td><td>" + data
                        .data[i]
                        .소재지 + "</td><td>" + data
                        .data[i]
                        .전화번호 + "</td></tr>";
                    $("table").append(txt);
                                     
                 // 주소들로 좌표를 검색합니다 json으로 받은 data.data[i].소재지를 넣어서 이름을 표시해주고,
                    // function(result,status)는 받은 소재지의 경도,위도가 표시된다.
                    geocoder.addressSearch(data.data[i].소재지, function (result, status) {
                    	console.log("주소 검색 상태:", status); // 상태 확인
                        //정상적으로 검색이 완료 됐으면 결과값으로 받은 위치를 마커로 표시합니다
                        if (status === kakao.maps.services.Status.OK) {
                            //내가 적은 소재지와 카카오 맵에 저장된 소재지가 일치한다면
                            let coords = new kakao
                                .maps
                                .LatLng(result[0].y, result[0].x);
                            // coords는 경도와 위도 marker라는 배열을 만들어서 배열안에 마커(객체)를 하나씩 담는다
                            let marker = new Array();
                            marker[i] = new kakao
                                .maps
                                .Marker({map: map, position: coords});
                             
                            // 인포윈도우로 장소에 대한 설명을 표시합니다.
                            let infowindow = new kakao.maps.InfoWindow({
                                content: '<div style = "width:150px;text-align:center;padding:6px 0;">' + data
                                    .data[i]
                                    .명칭 + '<div>'
                            })
                            infowindow.open(map, marker[i]);

                            //지도의 중심을 결과값으로 받은 위치로 이동시킵니다.
                            map.setCenter(coords);
                        }
                    });
                }
            }).fail(function(jqXHR, textStatus, errorThrown) {
                console.error("데이터 로드 실패: " + textStatus, errorThrown); // 오류 처리
            });

            
			
            // 주소로 좌표를 검색합니다
//             geocoder.addressSearch('경남 창원시 마산회원구 양덕북12길 113', function(result, status) {
//                 // 정상적으로 검색이 완료됐으면 
//                 if (status === kakao.maps.services.Status.OK) {
//                     var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

//                     // 결과값으로 받은 위치를 마커로 표시합니다
//                     var marker = new kakao.maps.Marker({
//                         map: map,
//                         position: coords
//                     });

//                     // 인포윈도우로 장소에 대한 설명을 표시합니다
//                     var infowindow = new kakao.maps.InfoWindow({
//                         content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
//                     });
//                     infowindow.open(map, marker);

//                     // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
//                     map.setCenter(coords);
//                 } else {
//                     alert('주소 검색 실패: ' + status); // 에러 처리 추가
//                 }
//             });
        });
    </script>
</body>
</html>