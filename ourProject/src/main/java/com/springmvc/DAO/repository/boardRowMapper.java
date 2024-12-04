package com.springmvc.DAO.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springmvc.DTO.Board;

public class boardRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Board board = new Board();
		board.setNumber(rs.getInt("number"));
		board.setDate(rs.getString("Date"));
		board.setSubject(rs.getString("subject"));
		board.setCategory(rs.getString("category"));
		board.setViewCount(rs.getInt("viewCount"));
		board.setSupportDeadline(rs.getDate("supportDeadline"));
		
		return board;
	}

}
