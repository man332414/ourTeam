package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springmvc.DAO.service.calendarEventService;
import com.springmvc.DTO.CalendarEvent;

@Controller
@RequestMapping("/calendar")
public class calendarController 
{
	@Autowired
	calendarEventService calendarEventService;
	
	@GetMapping
	public String goCalendar()
	{
		return "calendar";
	}
	
	@PostMapping("/addevents")
	public ResponseEntity<String> setEvent(@RequestBody CalendarEvent event)
	{
		System.out.println("calendarController.setEvent() 입장");
		calendarEventService.setEvent(event);
		System.out.println("------------------------------------------");
        return ResponseEntity.ok("이벤트가 성공적으로 저장되었습니다.");
	}
}
