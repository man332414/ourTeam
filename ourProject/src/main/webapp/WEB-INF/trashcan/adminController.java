package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.DAO.service.boardService;
import com.springmvc.DTO.Board;

@Controller
@RequestMapping("/admin")
public class adminController 
{
	@Autowired
	boardService boardService;
	
//	--------------------------------- 생성 ---------------------------------
	@GetMapping("/create")
	public String createBoardForm(@ModelAttribute Board board, Model model)
	{
		model.addAttribute("board", board);
		return "createBoard";
	}
	@PostMapping("/create")
	public String createBoard(@ModelAttribute Board board, Model moedl)
	{
		boardService.addBoard(board);
				
		return "redirect:/board/list";
	}

	
//	--------------------------------- 메서드 수준의 매핑 // 관리자 페이지로 이동 ---------------------------------
	@GetMapping
	public String adminPage()
	{
		return "admin";
	}
	
//	--------------------------------- 관리자 게시판으로 이동 ---------------------------------
	@GetMapping("/board")
	public String board(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="numberOfRows", defaultValue="10") int numberOfRows)
	{
		System.out.println("adminController.adminPage() 입장");
		List<Board> boards = boardService.getAllBoards(currentPage, numberOfRows);
		
		int totalPage = boardService.getTotalPage(numberOfRows);
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("boards",boards);
		
		System.out.println("------------------------------------------");

		return "adminBoard";
	}
	
//	--------------------------------- 삭제 ---------------------------------
	@GetMapping("/delete")
	public String deleteBoard(@RequestParam(required=false) List<Integer> number, Model model)
	{
		System.out.println("adminController.deleteBoard() 입장");
		System.out.print("뭐지울거야? ");
		if(number != null && !number.isEmpty())
		{
			for(int deleteNumber : number)
			{
				System.out.print(deleteNumber + ", ");
			}
			System.out.println("");
			
			boardService.deleteBoard(number);
			
			return "redirect:board";			
		}
		System.out.println("아무것도 없어? 그러면 곤란한데.. 다시 돌아가");
		String message = "<script>alert("+"선택된 항목이 없습니다. 선택 후 삭제버튼을 눌러주세요."+");</script>";
		model.addAttribute("message", message);
		return "redirect:board";
	}
	
//	--------------------------------- 수정 ---------------------------------
	@GetMapping("/update")
	public String updateBoardForm(@ModelAttribute Board board, @RequestParam int number, Model model)
	{
		Board boardUpdate = boardService.getOneBoard(number);
		model.addAttribute("board", boardUpdate);
		return "updateBoardForm";
	}
	
	@PostMapping("/update")
	public String updateBoard(@ModelAttribute Board board, Model model)
	{
		boardService.updateBoard(board);
		return "redirect:/admin/board";
	}

}
