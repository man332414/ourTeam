package com.springmvc.DAO.repository;

import java.util.List;
import java.util.Map;

import com.springmvc.DTO.Board;

public interface boardRepository {

	List<Board> getAllBoards(int currentPage, int numberOfRows);

	void saveAll(List<Board> boards);

	Board getOneBoard(Integer number);

	List<Map<String, Object>> getSearchResult(Map<String, String> searchFor);

	boolean isBoardList(String title);

	int getTotalPage(int numberOfRows);

}