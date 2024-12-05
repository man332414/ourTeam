package com.springmvc.DAO.service;

import java.util.List;
import java.util.Map;

import com.springmvc.DTO.Board;

public interface boardService 
{

	List<Board> getAllBoards();
	
	void saveAll();

	Board getOneBoard(Integer number);

	List<Map<String, Object>> getSearchResult(Map<String, String> searchFor);

}
