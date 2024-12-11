package com.springmvc.DAO.service;

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
	
}
