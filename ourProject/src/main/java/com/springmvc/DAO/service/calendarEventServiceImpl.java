package com.springmvc.DAO.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DAO.repository.calendarEventRepository;

@Service
public class calendarEventServiceImpl implements calendarEventService
{
	@Autowired
	calendarEventRepository calendarEventRepository; 
	
}
