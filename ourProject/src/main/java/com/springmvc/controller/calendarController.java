package com.springmvc.controller;

import java.time.ZoneOffset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	// =================================== 생성 ===================================
	@PostMapping("/addevents")
	public ResponseEntity<String> setEvent(@RequestBody CalendarEvent event)
	{
		System.out.println("calendarController.setEvent() 입장 : " + event.getStart());
		calendarEventService.setEvent(event);
		System.out.println("------------------------------------------");

        return ResponseEntity.ok("Event is successfully saved");
	}
	
	// =================================== 모두 읽어오기 ===================================
    @GetMapping("/events")
    @ResponseBody
    public ResponseEntity<List<CalendarEvent>> getAllEvents() {
        System.out.println("calendarController.getAllEvents() 입장");
        
        try {
            List<CalendarEvent> jsontypeData = calendarEventService.getAllEvents();
            
            // 데이터 확인을 위한 로그 출력
            System.out.println("조회된 이벤트 데이터: " + jsontypeData);
            
            // JSON 변환 확인을 위한 추가 로직
            ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper 생성
            String jsonOutput = objectMapper.writeValueAsString(jsontypeData); // List를 JSON 문자열로 변환
            System.out.println("JSON 형식으로 변환된 데이터: " + jsonOutput); // JSON 출력
            
            // 데이터가 올바른 형식인지 확인
            for (CalendarEvent data : jsontypeData) {
                System.out.println("제목: " + data.getTitle() + ", 시작: " + data.getStart());
            }
            
            System.out.println("------------------------------------------");
            return ResponseEntity.ok(jsontypeData);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    
}
	

