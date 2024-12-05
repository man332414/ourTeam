package com.springmvc.DAO.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.DTO.Board;

@Repository
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
	public void saveAll(List<Board> boards) 
	{
		String sql = "insert into board(number, date, title, category, content) values(?, ?, ?, ?, ?)";
		
		for(int i = 0; i<boards.size(); i++)
		{
			Board bd = boards.get(i);
			template.update(sql, null, bd.getDate(), bd.getTitle(), bd.getCategory(), bd.getContent());
			System.out.println("잘 넣고 있나? 방금넣은거 뭐야 보자 : " + bd.getTitle());
		}
	}

	@Override
	public Board getOneBoard(Integer number) 
	{
		String sql = "select * from board where number=?";
		
		Board board = (Board) template.queryForObject(sql, new Object[] {number},  new boardRowMapper());
		
		return board;
	}

	@Override
	public List<Map<String,Object>> getSearchResult(Map<String, String> searchFor) 
	{
//		System.out.println("boardRepositoryImpl.getSearchResult() 입장 : " + searchFor.get("searchFor"));
		String sql = "select count(*) from board where title like ?";
		String query = "%"+searchFor.get("searchFor")+"%";
		int cont = template.queryForObject(sql, new Object[]{query}, Integer.class);
		if(cont > 0)
		{
			System.out.println("boardRepositoryImpl.getSearchResult() 입장 : " + cont);
			sql = "select * from board where title like ?";
			List<Map<String, Object>> searchResult = template.query(sql, new Object[] {query}, new boardRowMapper());
			
//			Map<String, Object> searchResultToJson = new HashMap<String, Object>();			
//			for(int i = 0; i < searchResult.size(); i++)
//			{
//				System.out.println(searchResult.get(i));
//				searchResultToJson.putAll(searchResult.get(i));
//			}
			return searchResult;
		}
		else
		{
			return null;
		}
	}

}
