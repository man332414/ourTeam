<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.*"%>
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
        body{
        	background-color:#fefcf8;
        }
    </style>
</head>
<body>
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
				</div>
		    </div>
	    </div>
		<img src=<c:url value="/resources/images/main_banner.jpg"/> class="img-fluid" style="transform:translateY(-10%)" alt="">
	</section>
		
		<%@ include file="footer.jsp" %>

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
</body>

</html>