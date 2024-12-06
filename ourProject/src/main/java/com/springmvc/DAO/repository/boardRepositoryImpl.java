package com.springmvc.DAO.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
	public int getTotalPage(int numberOfRows)
	{
		System.out.println("boardRepository.getTotalPage() 입장");
		String totalBoardsQuery = "select count(*) from board";
		int totalBoards = template.queryForObject(totalBoardsQuery, Integer.class);
		int totalPage = totalBoards / numberOfRows;
		if((totalBoards%numberOfRows) != 0 && totalBoards > numberOfRows )
		{
			totalPage = totalPage+1;
		}
		System.out.println("전체페이지 요 있다. : " + totalPage + " = " + totalBoards + " / " + numberOfRows);

		return totalPage;
	}



	// 게시판 데이터베이스 읽어오기
	@Override
	public List<Board> getAllBoards(int currentPage, int numberOfRows) 
	{
		System.out.println("boardRepository.getAllBoards() 입장");
		// 현재 페이지에 띄울 아이템 추리기
		int offset = (currentPage-1) * numberOfRows;
		
		String sql = "select * from board order by number limit ? offset ?";
		List<Board> boards = template.query(sql, new Object[] {numberOfRows, offset}, new boardRowMapper());
		return boards;
	}

	// API 게시판 읽어오기 
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
	
	// 하나의 컨텐츠 읽어오기
	@Override
	public Board getOneBoard(Integer number) 
	{
		String sql = "select * from board where number=?";
		
		Board board = (Board) template.queryForObject(sql, new Object[] {number},  new boardRowMapper());
		
		return board;
	}

	// 검색 하기
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

	// API 읽어올 때 중복검사 하기
	@Override
	public boolean isBoardList(String title) 
	{
		System.out.println("boardRepository.isBoardList 입장");
		String sql="";
		sql = "select count(*) from board where title=?";
		int count = template.queryForObject(sql, new Object[] {title}, Integer.class);
		
		return count >= 1;
	}

}
