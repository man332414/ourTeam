package com.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		model.addAttribute("boards", boards);
		model.addAttribute("currentPage", currentPage);

		System.out.println("------------------------------------------");

		return "readAllBoards";
	}

//	--------------------------------- 하나만 읽어오기 ---------------------------------
	@GetMapping("/content")
	public String readContentsById(Model model, Integer number)
	{
		System.out.println("boardController.readContentsById() 입장 : " + number);

		Board board = boardService.getOneBoard(number);

		model.addAttribute("board", board);

		System.out.println("------------------------------------------");

		return "readOneBoard";
	}

//	--------------------------------- 검색하기 ---------------------------------
	@PostMapping("/list/searching")
	@ResponseBody
	public ResponseEntity<String> searching(@RequestBody Map<String, String> searchFor, Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="numberOfRows", defaultValue="10") int numberOfRows)
	{
		System.out.println("검색어 : " + searchFor.get("searchFor"));
		List<Map<String, Object>> searchResult = boardService.getSearchResult(searchFor, currentPage, numberOfRows);
		ObjectMapper objMapper = new ObjectMapper();
		String jsonResult ="";

		// totalPage를 json에 넣기 위한 똥꼬쇼
		int totalPage = boardService.getTotalPageForSeach(searchFor, numberOfRows);
		HashMap<String, Object> totalPageToJson = new HashMap<>();
		totalPageToJson.put("totalPage", totalPage);
		if(searchResult !=null)
		{
			searchResult.add(totalPageToJson);
		}

		// 와 그 흔적들
//		jsonResult = jsonResult + "totalPage" + "," + totalPage;
//		model.addAttribute("totalPage", totalPage);

		try
		{
			System.out.println("searcherResult 값은? "+ searchResult);
			jsonResult = objMapper.writeValueAsString(searchResult);
			System.out.println("jsonResult 값은? "+jsonResult);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		model.addAttribute("jsonResult", jsonResult);

		System.out.println("------------------------------------------");
		return ResponseEntity.ok(jsonResult);
	}

//	--------------------------------- 검색한거 페이지 이동 ---------------------------------
	@GetMapping("list/searched")
	public String searchedBoards(Model model, @RequestParam(value="search", defaultValue="") String searchFor,  @RequestParam(value="currentPage", defaultValue="1") int currentPage, @RequestParam(value="numberOfRows", defaultValue="10") int numberOfRows)
	{
		System.out.println("boardController.searchedBoards() 입장 : " + searchFor);
		List<Board> boards = boardService.getSearchedBoards(searchFor, currentPage, numberOfRows);
		int totalPage = boardService.getTotalPageForSeach(searchFor, numberOfRows);

		model.addAttribute("searchFor", searchFor);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("boards", boards);
		model.addAttribute("currentPage", currentPage);

		System.out.println("------------------------------------------");
		return "readAllBoards";
	}

////	--------------------------------- index에서 게시판 조회 ---------------------------------
//	@GetMapping("/index")
//	public String getIndex(Model model,
//	                       @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
//	                       @RequestParam(value = "numberOfRows", defaultValue = "10") int numberOfRows) {
//	    System.out.println("boardController.getIndex() 입장");
//
//	    List<Board> boards = boardService.getAllBoards(currentPage, numberOfRows);
//	    int totalPage = boardService.getTotalPage(numberOfRows);
//
//	    model.addAttribute("boards", boards);
//	    model.addAttribute("totalPage", totalPage);
//
//	    return "index"; // index.jsp로 이동
//	}

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

			return "redirect:list";
		}
		System.out.println("아무것도 없어? 그러면 곤란한데.. 다시 돌아가");
		String message = "<script>alert("+"선택된 항목이 없습니다. 선택 후 삭제버튼을 눌러주세요."+");</script>";
		model.addAttribute("message", message);
		return "redirect:list";
	}

//	--------------------------------- 수정 ---------------------------------
	@GetMapping("/update")
	public String updateBoardForm(@ModelAttribute Board board, @RequestParam int number, Model model)
	{
		Board boardUpdate = boardService.getOneBoard(number);
		model.addAttribute("board", boardUpdate);
		return "updateBoard";
	}

	@PostMapping("/update")
	public String updateBoard(@ModelAttribute Board board, Model model)
	{
		boardService.updateBoard(board);
		return "redirect:/board/list";
	}

}