package com.springmvc.DAO.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.DTO.CalendarEvent;

@Repository
public class calendarEventRepositoryImpl implements calendarEventRepository
{
	private JdbcTemplate template;

	@Autowired
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template=new JdbcTemplate(dataSource);

	}

	// 이벤트 생성기능
	@Override
	public void setEvent(CalendarEvent event)
	{
		System.out.println("calendarEventRepository.setEvent() 입장");
        String sql = "INSERT INTO CalendarEvent (title, start, end, all_day, description, location, category, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

        template.update
        (
    		sql, event.getTitle(),
    		event.getStart(),
    		event.getEnd() != null ? event.getEnd() : null,
    		event.isAllDay(),
    		event.getDescription(),
    		event.getLocation(),
    		event.getCategory()
       );
	}

	//모든 이벤트 읽어오기!
	@Override
	public List<CalendarEvent> getAllEvents(String userId)
	{
		System.out.println("calendarEventRepository.getAllEvents() 입장");
		List<CalendarEvent> events = null;
		if(userId!=null) 
		{
			String sql = "select * from CalendarEvent where userId=?";
			events = template.query(sql, new Object[] {userId}, new calendarRowMapper());			
		}
		return events;
	}

	//이벤트 업데이트
	@Override
	public void updateEvent(CalendarEvent event)
	{
		System.out.println("calendarEventRepository.updateEvent() 입장");
		String sql = "UPDATE CalendarEvent SET title = ?, start = ?, end = ?, all_day = ?, description = ?, location = ?, category = ? WHERE id = ?";
		template.update(sql, event.getTitle(), event.getStart(), event.getEnd(), event.isAllDay(), event.getDescription(), event.getLocation(), event.getCategory(), event.getId());
	}

	@Override
	public void deleteEvent(CalendarEvent event)
	{
		System.out.println("calendarEventRepository.deleteEvent() 입장");
		String sql = "delete from CalendarEvent where id=?";
		template.update(sql, event.getId());
	}

	// 생일에 따른 백신 접종일정 추가
	@Override
	public void setVaccinationSchedule(List<CalendarEvent> events)
	{
		for(CalendarEvent event : events)
		{
			String sql = "INSERT INTO CalendarEvent (title, start, end, all_day, description, location, category, userId, created_at, updated_at) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

			template.update
			(
				sql,
				event.getTitle(),
				event.getStart(),
				event.getEnd() != null ? event.getEnd() : null,
				event.isAllDay(),
				event.getDescription(),
				event.getLocation(),
				event.getCategory(),
				event.getUserId()
			);

//			System.out.println("description "+event.getDescription());
		}
	}
}
