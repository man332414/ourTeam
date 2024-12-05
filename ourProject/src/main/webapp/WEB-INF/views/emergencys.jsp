<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html Content-Type="application/xml">
<head>
 <link href = "http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">

<title>emergency</title>
</head>
<body>
	
	<div class="container">
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">emergency입니다</h1>
				<p class="col-md-8 fs-4">EmergencyRoomList s</p>   
				<a href="emergencys/add" >병원등록</a><br>   
				<a href="https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?ServiceKey=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D&pageNo=1&numOfRows=10" >병원등록aaa</a>
				<a href="https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList?ServiceKey=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D&pageNo=1&numOfRows=10" >병원api xml->json</a>
				<form action="convert" method="post" Content-Type="application/xml">
					<label>병원api xml->json method=post</label>
					<input type="submit" value="Subscribe!" />
				</form>
				<form action="http://localhost:8080/convert" method="post" Content-Type="application/xml">
					<label>병원api xml->json method=post</label>
					<input type="submit" value="Subscribe!xx" />
				</form>
				
				<form action="convert"  method="get"  Content-Type="application/xml">
				    <fieldset>
				        <legend>병원api 폼</legend>
				        <label>병원api xml->json method=post
				            <input name="xml"/>
				        </label>
				        <button>병원api실행</button>
				    </fieldset>
				</form>
				
				
			</div>
		</div>
		<div class="row" align="center">	 	
			<c:forEach items="${emergencylist}" var="room">
				<div class ="col-md-4">
				
				
					<h3>${room.hosName}</h3>
					<p>${room.hosaddr }
						<br>${room.hosaddr}
						<p>거리= ${room.distance}km | 이동시간= ${room.travelTime} (분)
					<p>병상수는 ${room.numOfBad}개 있습니다
					<p>소아과: 
						<c:choose>
						<c:when test="${room.pediatrics == true}">
							<b> 있습니다</b>
						</c:when>
						<c:otherwise>
							<b> 없습니다						
						</c:otherwise>
						</c:choose>
					  , 산부인과:  
						<c:choose>
						<c:when test="${room.obstetricsAndGynecology == true}">
							<b> 있습니다
						</c:when>
						<c:otherwise>
							<b> 없습니다						
						</c:otherwise>
						</c:choose>
					<p><a href="<c:url value="/emergencys/room?id=${room.number}" />"
							class="btn btn-Secondary" role="button">상세정보 &raquo;</a>
					<br>
				</div>
			</c:forEach> 	
		</div>
		<hr>	

	</div>
</body>
</html>