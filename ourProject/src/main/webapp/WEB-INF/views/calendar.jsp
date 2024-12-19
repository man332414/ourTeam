<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<!-- <link href="https://cdn.jsdelivr.net/npm/@fullcalendar/core@6.1.15/main.min.css" rel="stylesheet"> -->
<script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
	body {
	  margin: 40px 10px;
	  padding: 0;
	  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	  font-size: 14px;
	}
	
	#calendar {
	  max-width: 1100px;
	  margin: 0 auto;
	}
  
	#eventModal 
	{
		display: none;
		position: fixed;
		z-index: 1000;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0,0,0,0.4);
	}
	.modal-content 
	{
		background-color: #fefefe;
		margin: 15% auto;
		padding: 20px;
		border: 1px solid #888;
		width: 300px;
	}
  
</style>
</head>
<body>
    <div id="eventModal">
        <div class="modal-content">
            <h2 id="modalTitle">새 일정 추가</h2>
			<form id="eventForm">
			    <input type="hidden" id="id"><br><br>
			    
			    <label for="title">이벤트 제목 (필수):</label>
			    <input type="text" id="title" name="title" required><br><br>
			
			    <label for="start">시작 날짜 및 시간 (필수):</label>
			    <input type="datetime-local" id="start" name="start" required><br><br>
			
			    <label for="end">종료 날짜 및 시간:</label>
			    <input type="datetime-local" id="end" name="end"><br><br>
			
			    <label for="allDay">하루 종일 이벤트:</label>
			    <input type="checkbox" id="allDay" name="allDay"><br><br>
			
			    <label for="description">이벤트 설명:</label>
			    <textarea id="description" name="description"></textarea><br><br>
			
			    <label for="location">이벤트 위치:</label>
			    <input type="text" id="location" name="location"><br><br>
			
			    <label for="category">이벤트 카테고리:</label>
			    <select id="category" name="category">
			        <option id="category_0" value="회의">회의</option>
			        <option id="category_1" value="일정">일정</option>
			        <option id="category_2" value="휴가">휴가</option>
			        <option id="category_3" value="기타">기타</option>
			    </select><br><br>
			
			    <button id="modalSubmitBtn" type="submit">저장</button>
			    <button id="closeBtn">취소</button>
			    <button id="deleteButton" style="display:none;">삭제</button>
			</form>
        </div>
    </div>

	<div id='calendar'></div>
</body>
<script src="/ourProject/resources/js/(calendar.jsp)fullCalendar.js"></script>
</html>
