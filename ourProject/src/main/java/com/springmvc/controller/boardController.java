package com.springmvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmvc.DAO.service.boardService;
import com.springmvc.DTO.Board;

@Controller
@RequestMapping("/board")
public class boardController
{
	@Autowired
	private boardService boardService;	
	
//	--------------------------------- 새로고침 ---------------------------------
	@GetMapping("/refresh")
	public String saveAll()
	{
		System.out.println("boardController.saveAll() 입장");
		boardService.saveAll();
		System.out.println("------------------------------------------");
		return "redirect:/";
	}
	
//	--------------------------------- 전체 다 읽어오기 ---------------------------------
	@GetMapping("/list")
	public String readAllBoards(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="numberOfRows", defaultValue="10") int numberOfRows)
	{
		System.out.println("boardController.readAllBoards() 입장");
		List<Board> boards = boardService.getAllBoards(currentPage, numberOfRows);
		
		int totalPage = boardService.getTotalPage(numberOfRows);
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("boards",boards);
		
		System.out.println("------------------------------------------");

		return "board";
	}
	
//	--------------------------------- 하나만 읽어오기 ---------------------------------
	@GetMapping("/content")
	public String readContentsById(Model model, Integer number)
	{
		System.out.println("boardController.readContentsById() 입장 : " + number);
		
		Board board = boardService.getOneBoard(number);

		model.addAttribute("board", board);
		
		System.out.println("------------------------------------------");
		
		return "oneBoard";
	}
//	--------------------------------- 검색하기 ---------------------------------
	@PostMapping("/list/searching")
	@ResponseBody
	public ResponseEntity<String> searching(@RequestBody Map<String, String> searchFor, Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="numberOfRows", defaultValue="10") int numberOfRows)
	{
		System.out.println("검색어 : " + searchFor.get("searchFor"));
		List<Map<String, Object>> searchResult = boardService.getSearchResult(searchFor/* , currentPage, numberOfRows */);
		ObjectMapper objMapper = new ObjectMapper();
		String jsonResult ="";
//		int totalPage = boardService.getTotalPageForSeach(searchFor, numberOfRows);
		try 
		{
			jsonResult = objMapper.writeValueAsString(searchResult);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
//		model.addAttribute("totalPage", totalPage);
		model.addAttribute("jsonResult", jsonResult);
		
		return ResponseEntity.ok(jsonResult);
	}
		
}