package com.springmvc.DAO.service;

import java.util.List;

import com.springmvc.DTO.Board;

public interface boardService 
{

	List<Board> getAllBoards();

	List<Board> fatchBoardFormApi();

	void saveBoardsFromJson(List<Board> apiBoard);

}
