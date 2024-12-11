package com.springmvc.DAO.repository;

import java.sql.Timestamp;

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

	@Override
	public void setEvent(CalendarEvent event) 
	{
		System.out.println("calendarEventRepository.setEvent() 입장");
        String sql = "INSERT INTO events (title, start, end, all_day, description, location, category, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

        template.update(sql, event.getTitle(),
                       Timestamp.valueOf(event.getStart()),
                       event.getEnd() != null ? Timestamp.valueOf(event.getEnd()) : null,
                       event.isAllDay(),
                       event.getDescription(),
                       event.getLocation(),
                       event.getCategory(),
                       event.getUserId());
	}

}
