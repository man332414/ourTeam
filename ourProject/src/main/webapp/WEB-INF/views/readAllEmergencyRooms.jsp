<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="http://localhost:8080/ourProject/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <title>응급실 관리</title>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
   
	<style>
    .scroll-top {
        position: fixed;
        bottom: 70px; /* 하단에서 위로 위치 조정 */
        right: 20px;
        display: none; /* 초기에는 숨김 */
        z-index: 1000; /* 다른 요소 위에 표시 */
    }
    .scroll-bottom {
        position: fixed;
        bottom: 20px; /* 하단에서 위치 조정 */
        right: 20px;
        display: none; /* 초기에는 숨김 */
        z-index: 1000; /* 다른 요소 위에 표시 */
    }
	</style>
	
    
	<script>
    $(document).ready(function() {
        // 스크롤 시 버튼 표시
        $(window).scroll(function() {
            if ($(this).scrollTop() > 100) {
                $('.scroll-btn').fadeIn(); // 버튼 표시
            } else {
                $('.scroll-btn').fadeOut(); // 버튼 숨김
            }
        });

        // 상단으로 스크롤
        $('.scroll-top').click(function() {
            $('html, body').animate({scrollTop: 0}, 800);
        });

        // 하단으로 스크롤
        $('.scroll-bottom').click(function() {
            $('html, body').animate({scrollTop: $(document).height()}, 800);
        });
    });
	</script>
    
</head>
<body>
<!--     <nav class="navbar navbar-expand-lg navbar-light bg-light"> -->
<!--         <div class="container"> -->
<!--             <a class="navbar-brand" href="#">프로젝트 이름</a> -->
<!--             <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation"> -->
<!--                 <span class="navbar-toggler-icon"></span> -->
<!--             </button> -->
<!--             <div class="collapse navbar-collapse" id="navbarNav"> -->
<!--                 <ul class="navbar-nav"> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="index.jsp">홈</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="emergencys">응급실 관리</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="products">출산용품 관리</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="diary">성장일기</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="consultation">상담 요청</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="community">커뮤니티</a> -->
<!--                     </li> -->
<!--                     <li class="nav-item"> -->
<!--                         <a class="nav-link" href="profile">내 정보</a> -->
<!--                     </li> -->
<!--                 </ul> -->
<!--             </div> -->
<!--         </div> -->
<!--     </nav> -->
	<%@ include file="header.jsp" %>

    <div class="container">
        <div class="mb-4 bg-light rounded-3">
            <div class="container-fluid py-1"><br>
                <h1 class="display-5 fw-bold">응급실 관리</h1>
                <a href="emergencys/add" class="btn btn-primary">병원 등록</a>
                <a href="emergencys/addapi" class="btn btn-secondary">병원 등록 API</a>
                <p class="col-md-8 fs-4">응급실 목록을 확인하세요.</p>
            </div>
        </div>
        
        <!-- 검색 및 정렬 옵션 -->
		<div class="mb-4">
		    <form method="GET" action="emergencys">
		        <div class="input-group">
		            <input type="text" name="keyword" class="form-control" placeholder="병원 이름 검색" >
		            <select name="sort" class="form-select">
		                <option value="hosName">이름순</option>
		                <option value="distance">거리 순</option>
		                <option value="numOfBad">병상수 순</option>
		            </select>
		            <button class="btn btn-outline-secondary" type="submit">검색</button>
		        </div>
		    </form>
		</div>

        <div class="row">
          <c:if test="${not empty emergencylist}"> 
            <c:forEach items="${emergencylist}" var="room">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title d-flex justify-content-between">
                             <span>${room.hosName}</span>
						     <span>ID: ${room.number}</span>
                            </h5><br>
                            <p class="card-text">${room.hosaddr}<br></p>
                            <p>거리: ${room.distance} km | 이동시간: ${room.travelTime} 분</p>
                            <p>병상수: ${room.numOfBad}개</p>
                            <p>소아과: 
                                <c:choose>
                                    <c:when test="${room.pediatrics}">
                                        <b>있습니다</b>
                                    </c:when>
                                    <c:otherwise>
                                        <b>없습니다</b>
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <p>산부인과:  
                                <c:choose>
                                    <c:when test="${room.obstetricsAndGynecology}">
                                        <b>있습니다</b>
                                    </c:when>
                                    <c:otherwise>
                                        <b>없습니다</b>
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <a href="<c:url value="/emergencys/${room.number}" />"    class="btn btn-secondary">상세정보 &raquo;</a>
                            <a href="<c:url value='/emergencys/update?number=${room.number}' />" class="btn btn-warning">수정</a>
                            <button class="btn btn-danger delete-button" data-id="${room.number}">삭제</button> <!-- Ajax 삭제 버튼 -->
                            <a href="javascript:void(0);" 
                            onclick="window.open('https://map.kakao.com/link/to/${room.hosName},${room.latitude},${room.longitude}/from/집,35.232058,128.583789', 
                            		'_blank', 'width=981, height=650')">
							        목적지 지도보기 </a>
                        </div>
                    </div>
                </div>
               
            </c:forEach>
            </c:if>
            <c:if test="${empty emergencylist}">
                <p>작성된 병원목록이 없습니다.</p>
            </c:if>
        </div>
        
        <hr>
        
        
		<!-- 하단으로 스크롤 버튼 -->
		<button class="scroll-btn btn btn-primary scroll-bottom" title="하단으로 이동">
		    <i class="fas fa-arrow-down"></i>
		</button>
		
		<!-- 상단으로 스크롤 버튼 -->
		<button class="scroll-btn btn btn-primary scroll-top" title="상단으로 이동">
		    <i class="fas fa-arrow-up"></i>
		</button>
		
        
    </div>

	<script>
	$(document).ready(function() {
        $('.delete-button').click(function() {
            var emergencyNum = $(this).data('id');
            console.log("data-id= ",emergencyNum);
            if (confirm('정말로 삭제하시겠습니까?')) {
                $.ajax({
                	url: 'emergencys/delete/' + emergencyNum,
                    type: 'DELETE',
                    success: function(result) {
                        alert('병원이 삭제되었습니다.');
                        location.reload(); // 페이지 새로 고침
                    },
                    error: function(xhr, status, error) {
                        console.error('삭제에 실패했습니다: ' + error);
                        alert('삭제에 실패했습니다: ' + error);
                    }
                });
            }
        });
    });
    </script>
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
</body>
</html>