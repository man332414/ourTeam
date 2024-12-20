package com.springmvc.DAO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DAO.repository.calendarEventRepository;
import com.springmvc.DTO.CalendarEvent;

@Service
public class calendarEventServiceImpl implements calendarEventService
{
	@Autowired
	calendarEventRepository calendarEventRepository;

	@Override
	public void setEvent(CalendarEvent event) 
	{
		calendarEventRepository.setEvent(event);
	}

	@Override
	public List<CalendarEvent> getAllEvents() 
	{
		System.out.println("calendarEventService.getAllEvents() 입장");
		return calendarEventRepository.getAllEvents();
	}

	@Override
	public void updateEvent(CalendarEvent event) 
	{
		System.out.println("calendarEventService.updateEvent() 입장");
		calendarEventRepository.updateEvent(event);
	}

	@Override
	public void deleteEvent(CalendarEvent event)
	{
		System.out.println("calendarEventService.deleteEvent() 입장");
		calendarEventRepository.deleteEvent(event);
	} 
	
}
