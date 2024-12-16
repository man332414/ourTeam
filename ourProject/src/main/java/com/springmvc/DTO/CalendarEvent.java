package com.springmvc.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CalendarEvent 
{
    private String id; // 고유 ID
    private String title; // 이벤트 제목
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime start; // 시작 날짜 및 시간
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime end; // 종료 날짜 및 시간 (선택적)
    private boolean allDay; // 하루 종일 이벤트인지 여부 (선택적)
    private String description; // 이벤트 설명 (선택적)
    private String location; // 이벤트 위치 (선택적)
    private String category; // 이벤트 카테고리 (예: "회의", "일정", "휴가" 등)
    private String userId; // 이벤트 소유자 사용자 ID
    
	public CalendarEvent() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
//		System.out.println("CalendarEvent.getEnd() 입장 : " + end);
//		if(end!=null) 
//		{
//			return end.minusMonths(1);
//		}
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	public boolean isAllDay() {
		return allDay;
	}
	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
