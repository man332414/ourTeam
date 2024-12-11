package com.springmvc.DAO.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.DTO.CalendarEvent;

public class calendarRowMapper implements RowMapper<CalendarEvent>
{

	@Override
	public CalendarEvent mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		CalendarEvent event = new CalendarEvent();
        event.setId(rs.getString("id")); // ID
        event.setTitle(rs.getString("title")); // 제목
        event.setStart(rs.getTimestamp("start").toLocalDateTime()); // 시작 시간
        event.setEnd(rs.getTimestamp("end") != null ? rs.getTimestamp("end").toLocalDateTime() : null); // 종료 시간
        event.setAllDay(rs.getBoolean("all_day")); // 하루 종일 여부
        event.setDescription(rs.getString("description")); // 설명
        event.setLocation(rs.getString("location")); // 위치
        event.setCategory(rs.getString("category")); // 카테고리
        event.setUserId(rs.getString("user_id")); // 사용자 ID

		return event;
	}

}
