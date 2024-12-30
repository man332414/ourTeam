package com.springmvc.DAO.repository;

import java.util.List;

import com.springmvc.DTO.CalendarEvent;

public interface calendarEventRepository
{

	void setEvent(CalendarEvent event);

	List<CalendarEvent> getAllEvents(String userId);

	void updateEvent(CalendarEvent event);

	void deleteEvent(CalendarEvent event);

	void setVaccinationSchedule(List<CalendarEvent> events);

}
