package com.springmvc.DAO.service;

import java.util.List;

import com.springmvc.DTO.CalendarEvent;

public interface calendarEventService 
{

	void setEvent(CalendarEvent event);

	List<CalendarEvent> getAllEvents();

	void updateEvent(CalendarEvent event);

	void deleteEvent(CalendarEvent event);

}
