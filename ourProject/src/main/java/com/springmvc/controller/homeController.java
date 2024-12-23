package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.DAO.service.boardService;
import com.springmvc.DTO.Board;

@Controller
@RequestMapping
public class homeController 
{
	@Autowired
	private boardService boardService;	

//	--------------------------------- 집으로 가기 ---------------------------------
	@GetMapping
	public String goHomedefault(Model model)
	{
		System.out.println("homeController.goHomeDefault() 입장");
		List<Board> boards = boardService.getSomeBoards();
		model.addAttribute("boards",boards);
		System.out.println("------------------------------------------");

		return "home";
	}
	
	@GetMapping("/home")
	public String goHome(Model model)
	{
		System.out.println("homeController.goHome() 입장");
		List<Board> boards = boardService.getSomeBoards();
		model.addAttribute("boards",boards);
		System.out.println("------------------------------------------");

		return "home";
	}
}
