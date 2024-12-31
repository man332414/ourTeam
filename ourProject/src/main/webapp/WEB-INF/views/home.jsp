<%@ page session = "false" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MombyGrow</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
    <style>
        /* 지도 스타일 설정 */
        #map {
            width: 100%;
            height: 350px;
        }
    </style>
</head>
<body>
<!--     <header class="bg-light py-3 fixed-top"> -->
<!--         <div class="container text-center"> -->
<!--             <h1>임산부 정보 취합 프로젝트</h1> -->
<!--             <nav class="nav justify-content-center"> -->
<!--                 <a class="nav-link" href="signIn">회원 가입</a> -->
<!--                 <a class="nav-link" href="readMembers">회원 관리</a> -->
<!--                 <a class="nav-link" href="board/list">게시판</a> -->
<!--                 <a class="nav-link" href="calendar">일정 관리</a> -->
<!--                 <a class="nav-link" href="emergencys">응급실 관리</a> -->
<!--                 <a class="nav-link" href="products">출산/육아용품 관리</a> -->
<!--                 <a class="nav-link" href="diarys">성장일기</a> -->
<!--                 <a class="nav-link" href="map">지도</a> -->
<!--             </nav> -->
<!--         </div> -->
<!--     </header> -->
	<section class="overflow-hidden position-relative" style="height: 900px;">
		<%@ include file="header.jsp" %>
		<div class="position-absolute" style="padding:80px 0px; left:10%; top:20%; z-index:1000;">
		    <div class="container ">
		    	<div class=" row col-lg-10 text-light">
				    <h2>환영합니다!</h2>
			    	<p>엄마와 아이가 함께 성장할 수 있는 서비스를 지향합니다.</p>
		    	</div>
				<div class="row position-relative container-fluid" style="top:300px; left:110px;">
				  <div class="col">
				    <div class="card" style="background-color:#ffffff7d;">
				      <div class="card-body">
				        <h5 class="card-title">응급실 찾기</h5>
				        <p class="card-text">응급상황에서 응급실이 있는 병원을 찾고 위치를 알려줍니다.</p>
						<a class="btn btn-primary btn-lg" href="emergencys">응급실 찾기</a>
				      </div>
				    </div>
				  </div>
				  <div class="col">
				    <div class="card" style="background-color:#ffffff7d;">
				      <div class="card-body">
				        <h5 class="card-title">신생아, 영아 백신접종 일정관리</h5>
				        <p class="card-text">놓치기 쉬운 영유아 백신접종을 놓치지 않도록 <br> 일정관리를 제공합니다.</p>
						<a class="btn btn-primary btn-lg" href="calendar">백신접종 일정</a>
				      </div>
				    </div>
				  </div>
  				  <div class="col">
				    <div class="card" style="background-color:#ffffff7d;">
				      <div class="card-body">
				        <h5 class="card-title">성장일기</h5>
				        <p class="card-text">출산을 준비하고 육아를 하면서 하루하루 일기를 작성하며 아이와 부모의 성장을 기록합니다.</p>
						<a class="btn btn-primary btn-lg" href="diarys">성장일기 작성</a>
				      </div>
				    </div>
				  </div>
<!-- 					<h2 class="text-center">주요 기능</h2> -->
<!-- 					<div class="row text-center"> -->
<!-- 						<div class="col-md-4"> -->
<!-- 								<button class="btn btn-primary btn-lg" onclick="location.href='emergencys'">응급실 찾기</button> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-4"> -->
<!-- 								<button class="btn btn-primary btn-lg" onclick="location.href='products'">출산용품 관리</button> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-4"> -->
<!-- 								<button class="btn btn-primary btn-lg" onclick="location.href='diarys'">성장일기 작성</button> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
		    </div>
	    </div>
		<img src="${pageContext.request.contextPath}/resources/images/main_banner.jpg" class="img-fluid" style="transform:translateY(-10%)" alt="">
	</section>
		
<!--     <section id="map-section" class="mb-4"> -->
<!--         <h2 class="text-center"><a href="/ourProject/map">지도</a></h2> -->
<!--         <div id="map"></div> -->
<!--     </section> -->

<!--      <section id="board" class="mb-4"> -->
<!--         <h2 class="text-center">임산부지원게시판</h2> -->
<!--         <table class="table table-bordered"> -->
<!--             <thead> -->
<!--                 <tr> -->
<!--                     <th>순번</th> -->
<!--                     <th>분류</th> -->
<!--                     <th>제목</th> -->
<!--                     <th>게시일자</th> -->
<!--                     <th>비고</th> -->
<!--                 </tr> -->
<!--             </thead> -->
<!--             <tbody id="resultBody"> -->
<%--                 <c:forEach var="board" items="${boards}"> --%>
<!--                     <tr> -->
<%--                         <td><a href="${board.content}">${board.number}</a></td> --%>
<%--                         <td><a href="${board.content}">${board.category}</a></td> --%>
<%--                         <td><a href="${board.content}">${board.title}</a></td> --%>
<%--                         <td><a href="${board.content}">${board.date}</a></td> --%>
<%--                         <td><a href="${board.content}"></a></td> --%>
<!--                     </tr> -->
<%--                 </c:forEach> --%>
<!--             </tbody> -->
<!--         </table> -->
<%--         <% int totalPage = 0; %> --%>
<!--         <div id="pages" class="text-center"> -->
            
<!--             <a href="board/list">더보기</a>	 -->
<!--         </div> -->
<!--     </section> -->
         
<!--         <section id="recommended-content" class="mb-4"> -->
<!--             <h2 class="text-center">추천 콘텐츠</h2> -->
<!--             <ul class="list-group"> -->
<!--                 <li class="list-group-item"><a href="#blog1">임신 초기 건강 관리</a></li> -->
<!--                 <li class="list-group-item"><a href="#blog2">영양 가이드</a></li> -->
<!--                 <li class="list-group-item"><a href="#blog3">운동과 스트레스 관리</a></li> -->
<!--                 <li class="list-group-item"><a href="./indexy.jsp">indexy</a></li> -->
<!--                 <li class="list-group-item"><a href="./indexrt.jsp">indexrt</a></li> -->
<!--             </ul> -->
<!--         </section> -->
		<%@ include file="footer.jsp" %>
<!-- 	</footer>    <footer class="bg-light text-center py-3"> -->
<!--         <p>연락처: info@example.com</p> -->
<!--         <p><a href="#terms">이용 약관</a> | <a href="#privacy">개인정보 처리방침</a></p> -->
<!--     </footer> -->

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>    
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script>
		// 메인페이지의 상단 배너 만 fix-top 상태로 만들기 위한 코드
		// 메인 홈페이지 로드 시 background-Image 속성 삭제
		let banner = document.querySelector("#mainBanner");
		console.log("banner: "+banner)

		document.addEventListener("DOMContentLoaded", removestyle);
		
		function removestyle()
		{
			console.log("removeStyle 입장");
			banner.style.removeProperty("background-Image");
		}
	</script>
<!--     <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=9c0a4381f5a94e6cb0eef56dbcf98cb6"></script> -->
<!--     <script>
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
     </script> -->
</body>

</html>