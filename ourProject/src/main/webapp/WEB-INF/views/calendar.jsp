<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link href="https://cdn.jsdelivr.net/npm/@fullcalendar/core@6.1.15/main.min.css" rel="stylesheet">
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
	<button id="addBtn">일정추가</button>
    <div id="eventModal">
        <div class="modal-content">
            <h2>새 일정 추가</h2>
			<form id="eventForm">
			    <label for="title">이벤트 제목:</label>
			    <input type="text" id="title" name="title" required><br><br>
			
			    <label for="start">시작 날짜 및 시간:</label>
			    <input type="datetime-local" id="start" name="start" required><br><br>
			
			    <label for="end">종료 날짜 및 시간 (선택적):</label>
			    <input type="datetime-local" id="end" name="end"><br><br>
			
			    <label for="allDay">하루 종일 이벤트:</label>
			    <input type="checkbox" id="allDay" name="allDay"><br><br>
			
			    <label for="description">이벤트 설명:</label>
			    <textarea id="description" name="description"></textarea><br><br>
			
			    <label for="location">이벤트 위치:</label>
			    <input type="text" id="location" name="location"><br><br>
			
			    <label for="category">이벤트 카테고리:</label>
			    <select id="category" name="category">
			        <option value="회의">회의</option>
			        <option value="일정">일정</option>
			        <option value="휴가">휴가</option>
			        <option value="기타">기타</option>
			    </select><br><br>
			
			    <button type="submit">이벤트 저장</button>
			    <button id="closeBtn">취소</button>
			</form>
        </div>
    </div>

	<div id='calendar'></div>
</body>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		let calendarEl = document.getElementById('calendar');
// 		console.log(calendarEl);
		let calendar = new FullCalendar.Calendar(calendarEl, {
				headerToolbar: {
					left: 'prev,next today',
					center: 'title',
					right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
				},
		    initialView: 'dayGridMonth',
// 		    events: '/calendar/events', // 서버에서 이벤트 가져오기
			navLinks: true, // can click day/week names to navigate views
			businessHours: true, // display business hours
			editable: true,
			selectable: true,			
		});
		calendar.render();
		
		let addBtn = document.querySelector("#addBtn");
		console.log(addBtn);
		let eventAddModal = document.querySelector("#eventModal");
		console.log(eventAddModal);
		let closeBtn = document.querySelector("#closeBtn");
				
		addBtn.addEventListener("click", appearFunc);
		closeBtn.addEventListener("click", disappearFunc);
		
		function appearFunc()
		{
			console.log("appearFunc() 입장")
			eventAddModal.style.display='block';
			
		}
		
		$('#eventForm').submit(function(e) {
		    e.preventDefault();  // 폼 제출을 막음

		    // 폼 데이터 수집
		    let eventData = {
		        title: $('#title').val(),
		        start: $('#start').val(),
		        end: $('#end').val() || null,  // 종료 날짜가 없으면 null
		        allDay: $('#allDay').is(':checked'),
		        description: $('#description').val() || null,
		        location: $('#location').val() || null,
		        category: $('#category').val()
		    };

		    // 서버로 JSON 데이터 전송
		    $.ajax({
		        url: 'calendar/addevents',  // 서버의 이벤트 수신 URL
		        method: 'POST',
		        contentType: 'application/json',
		        data: JSON.stringify(eventData),
		        success: function(response) {
		            console.log('이벤트 저장 성공:', response);
		        },
		        error: function(xhr, status, error) {
		            console.error('이벤트 저장 실패:', error);
		        }
		    });
		    disappearFunc();
		});
		
		function disappearFunc()
		{
			console.log("disappearFunc() 입장")
			eventAddModal.style.display='none';
		}
			
});
</script>
</html>
