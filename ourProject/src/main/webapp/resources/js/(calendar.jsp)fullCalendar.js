document.addEventListener('DOMContentLoaded', function() {
//	full calendar 초기화
	let eventAddModal = document.querySelector("#eventModal"); // 이벤트 추가하는 모달
	console.log(eventAddModal);
	let closeBtn = document.querySelector("#closeBtn"); //모달의 닫기 버튼
	let addEventForm = document.querySelector("#eventForm"); //모달의 핵심 폼
	let calendarEl = document.getElementById('calendar');
	console.log(calendarEl);
	let eventData = null; // 이벤트 데이터 저장소
	closeBtn.addEventListener("click", disappearFunc);
	
	// 폼 제출 이벤트와 elementForm 함수 연결
	addEventForm.addEventListener("submit", elementForm);
	
	let calendar = new FullCalendar.Calendar(calendarEl, {
		//헤더 생긴거 설정
		headerToolbar: 
		{
			left: 'prev,next addEventButton today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
		},
		timeZone: 'UTC',
		//일정 추가
		customButtons: 
		{
			addEventButton: 
			{
			    text: 'add event...',
			    click: function() 
				{
					appearFunc();
					// jQuery의 사용자 입력 데이터 받아오기 기술
					elementForm(e);
				}
			}
		},
		//일정 클릭시 액션
		eventClick: function(info) 
		{
			var eventObj = info.event;
		    alert('Clicked ' + eventObj.title);
		},
		dayMaxEvents: true, // allow "more" link when too many events
		initialView: 'dayGridMonth',
	    events: './calendar/events', // 서버에서 이벤트 가져오기
		navLinks: true, // can click day/week names to navigate views
		businessHours: true, // display business hours
		editable: true,
		selectable: true,
	});
	calendar.render();
	
	function elementForm(e) {
	    e.preventDefault(); // 기본 동작 방지
	    const eventData = eventFormValues(); // 폼 데이터 가져오기
	    toServerAjax(eventData); // 서버로 데이터 전송
	}


	
	//모달 보여주기
	function appearFunc()
	{
		console.log("appearFunc() 입장")
		eventAddModal.style.display='block';
	}
	
	// jQuery의 사용자 입력 데이터 받아오기 기술
	function eventFormValues(){
		return{			
			title: $('#title').val(),
			start: $('#start').val(), // ISO 형식으로 변환
			end: $('#end').val() ? $('#end').val() : null,
			allDay: $('#allDay').is(':checked'),
			description: $('#description').val() || null,
			location: $('#location').val() || null,
			category: $('#category').val()
		}
	} 
		
	function toServerAjax(eventData)
	{
	    // 서버로 JSON 데이터 전송
	    $.ajax({
	        url: 'calendar/addevents',  // 서버의 이벤트 수신 URL
	        method: 'POST',
	        contentType: 'application/json',
	        data: JSON.stringify(eventData),
	        success: function(response) {
	            console.log('이벤트 저장 성공:', response);
				disappearFunc();
				calendar.refetchEvents(); // 캘린더 이벤트 새로고침
				addEventForm.reset();
	        },
	        error: function(xhr, status, error) {
				console.error('이벤트 저장 실패:', xhr.responseText);
				console.error('상태 코드:', xhr.status);
				console.error('에러:', error);
	        }
	    });
	}
	
	function disappearFunc()
	{
		console.log("disappearFunc() 입장")
		eventAddModal.style.display='none';
	}
		
});
