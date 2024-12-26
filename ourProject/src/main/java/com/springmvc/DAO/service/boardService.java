package com.springmvc.DAO.service;

import java.util.List;
import java.util.Map;

import com.springmvc.DTO.Board;

public interface boardService
{

	List<Board> getAllBoards(int currentPage, int numberOfRows);

	void saveAll();

	Board getOneBoard(Integer number);

	List<Map<String, Object>> getSearchResult(Map<String, String> searchFor, int currentPage, int numberOfRows);

	int getTotalPage(int numberOfRows);

	void deleteBoard(List<Integer> number);

	void updateBoard(Board board);

	void addBoard(Board board);

	public int getTotalPageForSeach(Map<String, String> searchFor, int numberOfRows);
	// 오버로딩
	int getTotalPageForSeach(String searchFor, int numberOfRows);

	List<Board> getSearchedBoards(String searchFor, int currentPage, int numberOfRows);

	List<Board> getSomeBoards();


}
