package com.springmvc.DAO.repository;

import java.util.List;
import java.util.Map;

import com.springmvc.DTO.Board;

public interface boardRepository {

	List<Board> getAllBoards(int currentPage, int numberOfRows);

	void saveAll(List<Board> boards);

	Board getOneBoard(Integer number);

	List<Map<String, Object>> getSearchResult(Map<String, String> searchFor , int currentPage, int numberOfRows);

	boolean isBoardList(String title);

	int getTotalPage(int numberOfRows);

	void deleteBoard(List<Integer> number);

	void updateBoard(Board board);

	void addBoard(Board board);
	
	public int getTotalPageForSeach(Map<String, String> searchFor, int numberOfRows);

	//오버로딩
	int getTotalPageForSeach(String searchFor, int numberOfRows);

	List<Board> getSearchedBoards(String searchFor, int currentPage, int numberOfRows);


}