<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
 <link href = "http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">

<title>emergency</title>
</head>
<body>
	
	<div class="container">
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">emergency입니다</h1>
				<p class="col-md-8 fs-4">EmergencyRoomList</p>      
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
							<b> 있습니다
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
<%-- 					<p>소아과: ${room.isPediatrics} --%>
<%-- 					<p>산부인과: ${room.isObstetricsAndGynecology} --%>
>>>>>>> 878c28593c852c6fe9dbdcad05f7eb3913744ffb
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