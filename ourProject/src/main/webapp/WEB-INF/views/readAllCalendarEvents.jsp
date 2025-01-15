<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
   	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
	body {
	  margin: 40px 10px;
	  padding: 0;
	  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	  font-size: 14px;
	  background-color: #fefcf8; /* 배경색 설정 */
	  list-style: none;
	}
	
	#calendar {
	  max-width: 1100px;
	  margin: 0 auto;
	}
	
	#calendar a{
		color:black;
	}
  
	#eventModal 
	{
		display: none;
		position: fixed;
		z-index: 100;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0,0,0,0.4);
	}
 	#modal-content
 	{ 
 		background-color: #fefefe;
 		margin: 15% auto;
 		padding: 20px;
 		border: 1px solid #888;
  		width: 500px;
 	}
</style>
<title>임산부 달력</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%
	   	if(member!=null)
	   	{
	   		String userId = member.getUserId();
			request.setAttribute("userId" , member.getUserId());
	   	}
	%>
<div id="eventModal">
    <div id="modal-content">
	    <div class="d-flex justify-content-between">
	        <h2 id="modalTitle">새 일정 추가</h2>
		    <button id="closeBtn" type="button" class="btn-close"></button>
	    </div>
            <input type="hidden" id="userId" value="<% if(member != null)
											            {
            												out.print(member.getUserId());
            											}%>">
        <form id="eventForm">
            <input type="hidden" id="id">
            <table class="table-borderless">
                <tr>
                    <td><label for="title">이벤트 제목 (필수):</label></td>
                    <td><input type="text" id="title" name="title" required class="col"></td>
                </tr>
                <tr>
                    <td><label for="start">시작 날짜 및 시간 (필수):</label></td>
                    <td><input type="datetime-local" id="start" name="start" required class="col"></td>
                </tr>
                <tr>
                    <td><label for="end">종료 날짜 및 시간:</label></td>
                    <td><input type="datetime-local" id="end" name="end" class="col"></td>
                </tr>
                <tr>
                    <td><label for="allDay">하루 종일 이벤트:</label></td>
                    <td><input type="checkbox" id="allDay" name="allDay"></td>
                </tr>
                <tr>
                    <td><label for="description">이벤트 설명:</label></td>
                    <td><textarea id="description" name="description" class="col"></textarea></td>
                </tr>
                <tr>
                    <td><label for="location">이벤트 위치:</label></td>
                    <td><input type="text" id="location" name="location" class="col"></td>
                </tr>
                <tr>
                    <td><label for="category">이벤트 카테고리:</label></td>
                    <td>
                        <select id="category" name="category" class="col">
                            <option id="category_0" value="회의">회의</option>
                            <option id="category_1" value="일정">일정</option>
                            <option id="category_2" value="휴가">휴가</option>
                            <option id="category_3" value="기타">기타</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: right;">
                        <button id="modalSubmitBtn" type="submit" class="btn btn-primary">저장</button>
                        <button id="deleteButton" type="submit" style="display:none;" class="btn btn-danger">삭제</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

	<div style="padding:140px 0 30px 0;">
<!-- 		<div class="position-absolute"> -->
<!-- 			<ul style="list-style:none;"> -->
<!-- 				<li><h2>일정 관리</h2></l	i> -->
				<li><a href="#" class="link-dark" id="eventAdderBtn">일정 추가하기</a></li>
<!-- 				<li>일정 모아보기</li> -->
<!-- 				<li>일정 검색하기</li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
		<div id='calendar'><!-- style="margin:0 0 0 750px; max-height:650px;" > --></div>
	</div>
	<%@ include file="footer.jsp" %>    
</body>
<script src="<c:url value="/resources/js/(readAllCalendarEvents.jsp)fullCalendar.js"/>"></script>
</html>
