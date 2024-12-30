package com.springmvc.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "readAllCalendarEvents";
	}

	// =================================== 생성 ===================================
	@PostMapping("/addevent")
	public ResponseEntity<String> setEvent(@RequestBody CalendarEvent event)
	{
		System.out.println("calendarController.setEvent() 입장 : " + event.getStart());
		calendarEventService.setEvent(event);
		System.out.println("------------------------------------------");

        return ResponseEntity.ok("Event is successfully saved");
	}

	// =================================== 모두 읽어오기 ===================================
	@GetMapping(value="/events", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CalendarEvent>> getAllEvents(Model model)
	{
		System.out.println("calendarController.getAllEvents() 입장");
		String userId = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("userId : " + userId);
		List<CalendarEvent> jsontypeData = calendarEventService.getAllEvents(userId);
//		for(CalendarEvent data:jsontypeData)
//		{
//			System.out.println("----------");
//			System.out.println("제목이랑 봐야 알겠는데 : "+data.getTitle());
//			System.out.println("설명 한번 보자 : "+data.getDescription());
//		}

		System.out.println("------------------------------------------");
		return ResponseEntity.ok(jsontypeData);
	}

	// =================================== 업데이트 ===================================
	@PostMapping("/updateevent")
	public ResponseEntity<String> updateEvent(@RequestBody CalendarEvent event)
	{
		System.out.println("calendarController.updateEvent() 입장 : " + event.getTitle());
		calendarEventService.updateEvent(event);

		System.out.println("------------------------------------------");
		return ResponseEntity.ok("Evens is successfully updated");
	}

	// =================================== 삭제 ===================================
	@PostMapping("/deleteevent")
	public ResponseEntity<String> deleteEvent(@RequestBody CalendarEvent event)
	{
		System.out.println("calendarController.deleteEvent() 입장 : " + event.getTitle());
		calendarEventService.deleteEvent(event);

		return ResponseEntity.ok("Evens is successfully deleted");
	}

}
