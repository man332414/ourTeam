package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "calendar";
	}
	
	@GetMapping("/events")
	@ResponseBody
	public List<CalendarEvent> getEvents()
	{
		List<CalendarEvent> events = new ArrayList<>();
		
		CalendarEvent event = new CalendarEvent();
		
		CalendarEvent event2 = new CalendarEvent();
		
		events.add(event);
		events.add(event2);
		
		return events;
	}
}
