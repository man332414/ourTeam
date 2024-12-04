package com.springmvc.DAO.repository;

import java.util.List;

import com.springmvc.DTO.Board;

public interface boardRepository {

	List<Board> getAllBoards();

	void saveAll(List<Board> boards);

}
