package com.springmvc.DAO.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.DAO.repository.calendarEventRepository;
import com.springmvc.DTO.CalendarEvent;

@Service
public class VaccinationScheduleServiceImpl implements VaccinationScheduleService 
{
	@Autowired
	calendarEventRepository calendarEventRepository;
	
	List<CalendarEvent> events;	
	LocalDateTime baseDate;
	
	private CalendarEvent createEvent(String title, LocalDateTime start, int durationWeeks, String description)
	{
		CalendarEvent vaccinationSchedule = new CalendarEvent();
		vaccinationSchedule.setTitle(title);
		vaccinationSchedule.setStart(start);
		vaccinationSchedule.setEnd(start.plusWeeks(durationWeeks));
		vaccinationSchedule.setAllDay(true);
		vaccinationSchedule.setDescription(description); 
		vaccinationSchedule.setCategory("백신");
				
		return vaccinationSchedule;
	}
	
	private CalendarEvent createEvent(String title, int plusPeriod, int durationWeeks, String description)
	{
		CalendarEvent vaccinationSchedule = new CalendarEvent();
		
		vaccinationSchedule.setTitle(title);
		vaccinationSchedule.setStart(events.getLast().getStart().plusMonths(plusPeriod));
		vaccinationSchedule.setEnd(vaccinationSchedule.getStart().plusWeeks(durationWeeks));
		vaccinationSchedule.setAllDay(true);
		vaccinationSchedule.setDescription(description); 
		vaccinationSchedule.setCategory("백신");
		
		return vaccinationSchedule;
	}	
	
	public void vaccinationSchedule(LocalDate babyBirthDay)
	{
		events = new ArrayList<CalendarEvent>();		
		LocalDateTime birth = babyBirthDay.atStartOfDay();
		// B형 간염
		baseDate = birth; //1차 접종 시작시기
		events.add(createEvent("B형 간염 1차", baseDate, 1, "HepB 1차"));
		events.add(createEvent("B형 간염 2차", 1, 1, "HepB 2차"));
		events.add(createEvent("B형 간염 3차", 5, 1, "HepB 3차"));
		
		// 디프테리아, 파상풍, 백일해
		baseDate = birth.plusMonths(2); //1차 접종 시작시기
		events.add(createEvent("디프테리아, 파상풍, 백일해 1차", baseDate, 1, "DTaP 1차"));		
		events.add(createEvent("디프테리아, 파상풍, 백일해 2차", 2, 1, "DTaP 2차"));
		events.add(createEvent("디프테리아, 파상풍, 백일해 3차", 2, 1, "DTaP 3차"));
		events.add(createEvent("디프테리아, 파상풍, 백일해 4차", 6, 1, "DTaP 4차"));
		events.add(createEvent("디프테리아, 파상풍, 백일해 5차", 36, 12, "DTaP 5차"));
		baseDate = birth.plusYears(10); //1차 접종 시작시기
		events.add(createEvent("디프테리아, 파상풍, 백일해", baseDate, 1, "Tdap"));
		
		// 디프테리아, 파상풍
		baseDate = birth.plusYears(10); //1차 접종 시작시기
		events.add(createEvent("디프테리아, 파상풍", baseDate, 52, "Td"));
		
		// 폴리오
		baseDate = birth.plusMonths(2); //1차 접종 시작시기
		events.add(createEvent("폴리오 1차", baseDate, 1, "IPV 1차"));
		events.add(createEvent("폴리오 2차", 2, 1, "IPV 2차"));
		events.add(createEvent("폴리오 3차", 2, 56, "IPV 3차"));
		events.add(createEvent("폴리오 4차", 36, 104, "IPV 5차"));
		
		//b형 헤모필루스 인플루엔자
		baseDate = birth.plusMonths(2); //1차 접종 시작시기
		events.add(createEvent("b형헤모필루스인플루엔자 1차", baseDate, 1, "Hib 1차"));
		events.add(createEvent("b형헤모필루스인플루엔자 2차", 2, 1, "Hib 2차"));
		events.add(createEvent("b형헤모필루스인플루엔자 3차", 2, 1, "Hib 3차"));
		events.add(createEvent("b형헤모필루스인플루엔자 4차", 6, 12, "Hib 2차"));
		
		//폐렴구균 감염증
		baseDate=birth.plusMonths(2); //1차 접종 시작시기
		events.add(createEvent("폐렴구균 감염증 1차", baseDate, 1, "PCV 1차"));
		events.add(createEvent("폐렴구균 감염증 2차", 2, 1, "PCV 2차"));
		events.add(createEvent("폐렴구균 감염증 3차", 2, 1, "PCV 3차"));
		events.add(createEvent("폐렴구균 감염증 4차", 6, 1, "PCV 4차"));
		
		//홍역, 유행성이하선염, 풍진
		baseDate = birth.plusMonths(12); //1차 접종 시작시기
		events.add(createEvent("홍역, 유행성이하선염, 풍진 1차", baseDate, 1, "MMR 1차"));
		events.add(createEvent("홍역, 유행성이하선염, 풍진 1차", 36, 102, "MMR 2차"));
		
		//수두
		baseDate = birth.plusMonths(12);
		events.add(createEvent("수두", baseDate, 1, "VAR"));
		
		//일본뇌염
		baseDate = birth.plusMonths(12);
		events.add(createEvent("일본뇌염 불활성화 백신 1차", baseDate, 1, "IJEV 1차"));
		events.add(createEvent("일본뇌염 불활성화 백신 2차", 1, 1, "IJEV 2차"));
		events.add(createEvent("일본뇌염 불활성화 백신 3차", 11, 1, "IJEV 3차"));
		events.add(createEvent("일본뇌염 불활성화 백신 4차", 36, 1, "IJEV 4차"));
		events.add(createEvent("일본뇌염 불활성화 백신 5차", 72, 1, "IJEV 5차"));
		baseDate = birth.plusMonths(12);
		events.add(createEvent("일본뇌염 약독화생백신 1차", baseDate, 1, "LJEV 1차"));
		events.add(createEvent("일본뇌염 약독화생백신 2차", 12, 1, "LJEV 2차"));
		
		// A형 간염
		baseDate = birth.plusMonths(12);
		events.add(createEvent("A형 간염 1차", baseDate, 1, "HepA 1차"));
		
		// 사람유두종바이러스 감염증
		baseDate = birth.plusYears(10);
		boolean immune = false;
		String hpvType = null;
		if(immune)
		{
			if(hpvType == "hpv2")
			{
				events.add(createEvent("사람유두종바이러스 감염증", baseDate, 1, "HPV2 1차 면역력이 약한사람은 3회 접종"));
				events.add(createEvent("사람유두종바이러스 감염증", 1, 1, "HPV2 2차 면역력이 약한사람은 3회 접종"));
				events.add(createEvent("사람유두종바이러스 감염증", 5, 1, "HPV2 3차 면역력이 약한사람은 3회 접종"));
			}
			else if(hpvType == "hpv4")
			{
				events.add(createEvent("사람유두종바이러스 감염증", baseDate, 1, "HPV4 1차 면역력이 약한사람은 3회 접종"));
				events.add(createEvent("사람유두종바이러스 감염증", 2, 1, "HPV4 2차 면역력이 약한사람은 3회 접종"));
				events.add(createEvent("사람유두종바이러스 감염증", 4, 1, "HPV4 3차 면역력이 약한사람은 3회 접종"));
			}
		}
		events.add(createEvent("사람유두종바이러스 감염증 1차", baseDate, 1, "HPV 1차"));
		events.add(createEvent("사람유두종바이러스 감염증 2차", 6, 26, "HPV 2차"));
		
		// 인플루엔자
		baseDate = birth.plusMonths(6);
		events.add(createEvent("인플루엔자 1차", baseDate, 1, "IIV 불활성화 백신"));
		
		//로티바이러스 감염증
		baseDate = birth.plusMonths(2);
		events.add(createEvent("로티바이러스 감염증 1차", baseDate, 1, "RV(경구용 백신) 1차"));
		events.add(createEvent("로티바이러스 감염증 2차", 2, 1, "RV(경구용 백신) 2차"));
		events.add(createEvent("로티바이러스 감염증 3차", 2, 1, "RV(경구용 백신) 3차"));
		
		calendarEventRepository.setVaccinationSchedule(events);
	}
}