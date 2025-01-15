//document.addEventListener('DOMContentLoaded', function() {
	//	full calendar 초기화
	let calendarEl = document.getElementById('calendar');
//	console.log(calendarEl);
	let userId = document.querySelector("#userId").value;
	console.log(userId);
	let getAllUrl = './calendar/events?userId='+userId;
	console.log();
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
					// addEventForm 제출 버튼에 할당된 이벤트로 제출 시 자동 저장 시켰음.
					addEventForm.reset();
					appearFunc();
										
					AjaxUrl='calendar/addevent'; // addevent로 이동
				}
			}
		},
		//일정 클릭시 수정 폼 제공
		eventClick: function(info) 
		{
			let eventObj = info.event;
//		    alert('Clicked ' + eventObj.id);
			// 클릭하면 클릭된 이벤트의 내용들을 모달의 벨류들로 집어넣고
			appearFunc();
			eventUpdateForm(eventObj);
			// 사용자가 수정을 누르면 데이터 폼이 ajax로 보낼 준비하고
//			delBtn.style.display='none';
			AjaxUrl='calendar/updateevent'; // updateevent로 이동
		},
		// 일정 드래그 시 일정 변경 저장
		eventChange: function(info)
		{
//			console.log("eventChange info : " + info);
			let eventObj = info.event;
			// 클릭하면 클릭된 이벤트의 내용들을 모달의 벨류들로 집어넣고
			eventUpdateForm(eventObj);
			eventData = eventFormValues(); // 폼 데이터 가져오기
			AjaxUrl='calendar/updateevent'; // updateevent로 이동
			toServerAjax(eventData)
		},
		dayMaxEvents: true, // allow "more" link when too many events
		initialView: 'dayGridMonth',
	    events: getAllUrl, // 서버에서 이벤트 가져오기
		navLinks: true, // can click day/week names to navigate views
		businessHours: true, // display business hours
		editable: true,
		selectable: true,
	});
	calendar.render();		
//});


let eventAddModal = document.querySelector("#eventModal"); // 이벤트 추가하는 모달
//console.log(eventAddModal);
let closeBtn = document.querySelector("#closeBtn"); //모달의 닫기 버튼
let addEventForm = document.querySelector("#eventForm"); //모달의 핵심 폼
let eventData = null; // 이벤트 데이터 저장소
let AjaxUrl = ''; // Ajaxurl 변수 선언 
let delBtn = document.querySelector("#deleteButton");
let eventAdderBtn = document.querySelector("#eventAdderBtn");

delBtn.addEventListener("click", deleteFunc);
closeBtn.addEventListener("click", disappearFunc);
addEventForm.addEventListener("submit", elementForm);
eventAdderBtn.addEventListener("click", funcEventAdderBtn);

function disappearFunc()
{
	console.log("disappearFunc() 입장")
	eventAddModal.style.display='none';
	addEventForm.reset();
}

function elementForm(e) {
    e.preventDefault(); // 기본 동작 방지
    eventData = eventFormValues(); // 폼 데이터 가져오기
	toServerAjax(eventData)
}

function deleteFunc()
{
	if(confirm($('#title').val()+" 일정을 삭제하시겠습니까?"))
	{
		AjaxUrl='calendar/deleteevent'; // deleteevent로 이동
	}
}

//모달 보여주기
function appearFunc()
{
	document.querySelector("#modalTitle").innerText = "새 일정 추가";
	document.querySelector("#modalSubmitBtn").innerHTML = "저장";

	console.log("appearFunc() 입장")
	eventAddModal.style.display='block';
}

// jQuery의 사용자 입력 데이터 받아오기 기술
function eventFormValues(){
	console.log("userId in eventFormValues() "+$('#userId').val());
	return{			
		title: $('#title').val(),
		start: $('#start').val(),
		end: $('#end').val() ? $('#end').val() : null,
		allDay: $('#allDay').is(':checked'),
		id: $('#id').val() || null,
//		extendedProps: {
			description: $('#description').val() || null,
			location: $('#location').val() || null,
			category: $('#category').val(),
			userId: $('#userId').val()
//		}
	}
} 
	
// 수정 시 모달 폼 만들기
function eventUpdateForm(eventObj)
{
	// 모달을 띄우면 모달의 submit 버튼은 수정으로 바뀌고 
	document.querySelector("#modalTitle").innerText = "일정 수정";
	document.querySelector("#modalSubmitBtn").innerHTML = "수정";
//	console.log(delBtn);
	delBtn.style.display='inline';
	
	// 수정 시 모달 폼에 데이터 집어넣기
	document.querySelector("#id").value = eventObj.id;
	document.querySelector("#userId").value = eventObj.extendedProps.userId;
	document.querySelector("#title").value = eventObj.title;
	console.log("제목 "+eventObj.title);
	document.querySelector("#start").value = toLocalISOString(eventObj.start);
//	console.log(eventObj.start);
	document.getElementById('end').value = toLocalISOString(eventObj.end);
//	console.log(eventObj.allDay);
	
	if(eventObj.allDay){document.querySelector("#allDay").setAttribute("checked", "");}
	else{document.querySelector("#allDay").removeAttribute("checked");}
	
	console.log("description 인데 뭐가 들었니? : "+eventObj.extendedProps.description);
	if(eventObj.extendedProps.description != undefined){document.querySelector("#description").value = eventObj.extendedProps.description;}
	if(eventObj.extendedProps.location != undefined){document.querySelector("#location").value = eventObj.extendedProps.location;}
	switch(eventObj.extendedProps.category)
	{
		case "일정" :
			document.querySelector("#category_1").setAttribute("selected","");
			break;
		case "휴가" :
			document.querySelector("#category_2").setAttribute("selected","");
			break;
		case "기타" :
			document.querySelector("#category_3").setAttribute("selected","");
			break;
		default :
			document.querySelector("#category_0").setAttribute("selected","");
			break;	
	}
} 

function toServerAjax(eventData)
{
    // 서버로 JSON 데이터 전송
    $.ajax({
        url: AjaxUrl,  // 서버의 이벤트 수신 URL
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(eventData),
        success: function(response) {
            console.log('이벤트 저장 성공:', response);
			disappearFunc();
			calendar.refetchEvents(); // 캘린더 이벤트 새로고침
        },
        error: function(xhr, status, error) {
			console.error('이벤트 저장 실패:', xhr.responseText);
			console.error('상태 코드:', xhr.status);
			console.error('에러:', error);
        }
    });
}

function toLocalISOString(date)
{
	if(date||null)
	{
		// 시간을 UTC 시간으로 변경 중
//		let offset = date.getTimezoneOffset(); 
		//기준시간 대비 현재 타임존의 시간 차이를 분단위로 반환, 기준시간보다 로컬시간이 빠르면 음수임.
	//	console.log(offset);
		
		//date.getTime()은 기준시간을 밀리초 단위로 반환 , offset 시간을 밀리초 단위로 변환 후 계산
//		let adjustedDate = new Date(date.getTime()+offset*60*1000);
//		console.log("변환 전 시간 : "+new Date(date.getTime()).toISOString().slice(0, 16));
//		console.log("offset : " + offset)
//		console.log("변환 후 시간 : "+adjustedDate.toISOString().slice(0, 16));
		return date.toISOString().slice(0, 16);
	}
	return null;
}

function funcEventAdderBtn()
{
	addEventForm.reset();
	appearFunc();
						
	AjaxUrl='calendar/addevent'; // addevent로 이동		
}