<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
    <link href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/6.1.15/main.min.css' rel='stylesheet' />
<script src="/ourProject/resources/js/fullcalendar-6.1.15/dist/index.global.js"></script>

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
            <h2>새 일정 추가</h2>
            <form id="eventForm">
                <label>제목:</label>
                <input type="text" id="eventTitle" required><br>
                <label>시작 날짜:</label>
                <input type="date" id="eventStart" required><br>
                <label>종료 날짜:</label>
                <input type="date" id="eventEnd"><br>
                <label>설명:</label>
                <textarea id="eventDescription"></textarea><br>
                <button type="submit">저장</button>
                <button type="button" id="closeModal">취소</button>
            </form>
        </div>
    </div>

	<div id='calendar'></div>
</body>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		let calendarEl = document.getElementById('calendar');
        let eventModal = document.getElementById('eventModal');
        let eventForm = document.getElementById('eventForm');
		let calendar = new FullCalendar.Calendar(calendarEl, {
				headerToolbar: {
					left: 'prev,next today',
					center: 'title',
					right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
				},
		    initialView: 'dayGridMonth',
		    events: '/calendar/events', // 서버에서 이벤트 가져오기
		    editable: true,
		    eventAdd: function(info) {
		        fetch('/calendar/events', {
		            method: 'POST',
		            body: JSON.stringify(info.event),
		            headers: {
		                'Content-Type': 'application/json'
		            }

			navLinks: true, // can click day/week names to navigate views
			businessHours: true, // display business hours
			editable: true,
			selectable: true,
			events: [
// 				{
// 				  title: '안녕하세요',
// 				  start: '2024-12-03T13:00:00',
// 				  constraint: 'businessHours'
// 				},
// 				{
// 				  title: 'Meeting',
// 				  start: '2024-12-13T11:00:00',
// 				  constraint: 'availableForMeeting', // defined below
// 				  color: '#257e4a'
// 				},
// 				{
// 				  title: 'Conference',
// 				  start: '2024-12-18',
// 				  end: '2023-01-20'
// 				},
// 				{
// 				  title: 'Party',
// 				  start: '2024-12-29T20:00:00'
// 				},
				
// 				// areas where "Meeting" must be dropped
// 				{
// 				  groupId: 'availableForMeeting',
// 				  start: '2024-12-11T10:00:00',
// 				  end: '2024-12-11T16:00:00',
// 				  display: 'background'
// 				},
// 				{
// 				  groupId: 'availableForMeeting',
// 				  start: '2024-12-13T10:00:00',
// 				  end: '2024-12-13T16:00:00',
// 				  display: 'background'
// 				},
				
// 				// red areas where no events can be dropped
// 				{
// 				  start: '2024-12-24',
// 				  end: '2024-12-28',
// 				  overlap: false,
// 				  display: 'background',
// 				  color: '#ff9f89'
// 				},
// 				{
// 				  start: '2024-12-06',
// 				  end: '2024-12-08',
// 				  overlap: false,
// 				  display: 'background',
// 				  color: '#ff9f89'
// 				}
			]
			
		});
		calendar.render();
		
		let addBtn = document.querySelector("#addBtn");
		console.log(addBtn);
		
		addBtn.addEventListener("click", addFunc)
		
		function addFunc()
		{
			calendar.addEvent({
				title: "new Event",
				start: "2024-12-15T16:00:00"
			});
		}

});
</script>
</html>
