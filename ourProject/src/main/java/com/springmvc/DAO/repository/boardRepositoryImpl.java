package com.springmvc.DAO.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc.DTO.Board;

public class boardRepositoryImpl implements boardRepository 
{
	private JdbcTemplate template;
	
	@Autowired
	public void setJdbctemplate(DataSource dataSource)
	{
		this.template=new JdbcTemplate(dataSource);
			
	}

	@Override
	public List<Board> getAllBoards() 
	{
		String sql = "select * from board";
		List<Board> boards = template.query(sql, new boardRowMapper());
		return boards;
	}

	@Override
	public void saveAll(List<Board> boards) {
		// TODO Auto-generated method stub
		
	}

}
