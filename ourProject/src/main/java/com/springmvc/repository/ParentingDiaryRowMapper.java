package com.springmvc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.DTO.parentingDiary;

public class ParentingDiaryRowMapper implements RowMapper<parentingDiary> {

	@Override
	public parentingDiary mapRow(ResultSet rs, int rowNum) throws SQLException {

		parentingDiary diary = new parentingDiary();

		diary.setId(rs.getInt(1));
		// ResultSet에서 문자열로 가져온 후 LocalDateTime으로 변환
	    String todayString = rs.getString(2);
	    if (todayString != null) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        LocalDateTime today = LocalDateTime.parse(todayString, formatter);
	        diary.setToday(today);
	    } else {
	        diary.setToday(null); // null 처리
	    }
		diary.setWeather(rs.getString(3));
		diary.setMyMood(rs.getString(4));
		diary.setDiaryText(rs.getString(5));
		diary.setFileName(rs.getString(6)); // 파일 이름을 저장
		diary.setUserId(rs.getString(7));

		return diary;
	}
}
