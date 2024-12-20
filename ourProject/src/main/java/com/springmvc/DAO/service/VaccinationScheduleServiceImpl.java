package com.springmvc.DAO.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.springmvc.DTO.CalendarEvent;

public class VaccinationScheduleServiceImpl implements VaccinationScheduleService 
{
	LocalDate babyBirthDay = null;
	List<CalendarEvent> events = null;
	// 예방접종 일정 기준
	
	// 날짜를 받아서 예방접종 일정 계산하는 로직 작성
	public void vaccinationSchedule(LocalDate babyBirthDay)
	{
		this.babyBirthDay = babyBirthDay;
		events = new ArrayList<CalendarEvent>();
		// B형 간염 백신
		// 1차 : 출생시
	}
	
	public void HepBVaccination(LocalDate babyBirthDay)
	{
		CalendarEvent vaccinationSchdule = new CalendarEvent();
		LocalDate baseDate = babyBirthDay;  
		
		// B형 간염 1차 접종 
		vaccinationSchdule.setTitle("B형 간염 1차");
		vaccinationSchdule.setStart(baseDate.plusMonths(0).atStartOfDay());
		vaccinationSchdule.setEnd(baseDate.plusMonths(0).plusWeeks(1).atStartOfDay());
		vaccinationSchdule.setAllDay(true);
		vaccinationSchdule.setDescription("HepB 1차");
		vaccinationSchdule.setCategory("백신");
		
		baseDate = vaccinationSchdule.getStart().toLocalDate();
		
		events.add(vaccinationSchdule);
	}
}
