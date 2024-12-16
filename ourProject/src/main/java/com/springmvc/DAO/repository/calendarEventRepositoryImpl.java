package com.springmvc.DAO.repository;

import java.sql.Timestamp;
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
	public List<CalendarEvent> getAllEvents()
	{
		System.out.println("calendarEventRepository.getAllEvents() 입장");
		String sql = "select * from CalendarEvent";
		return template.query(sql, new Object[] {}, new calendarRowMapper());
	}

}
