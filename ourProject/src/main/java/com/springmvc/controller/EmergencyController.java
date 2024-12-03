package com.springmvc.controller;


import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DTO.emergencyRoom;
import com.springmvc.service.EmergencyService;

@Controller
@RequestMapping("/emergencys")
public class EmergencyController {
	

	@Autowired // 컴포넌트 스캔되어야 함
	private EmergencyService emergencyService;
	
	//private EmergencyValidator emergencyValidator;
	
	
	@RequestMapping("/emergency")
	public String welcome(Model model) {
		model.addAttribute(model);
		return "emergency";
	}
		
	//@RequestMapping(value="/books", method=RequestMethod.GET)
	@GetMapping
	public String requestRoomList(Model model) {
		System.out.println("000.rc : RoomList 진입");
		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		System.out.println("뷰이동"+list);
		model.addAttribute("emergencylist",list);
		
		return "emergency";
	}
	
//	//@RequestMapping(value="/all")
//	@GetMapping("/all")
//	public String requestAllBooks(Model model) {
//		System.out.println("000.bc AllBook : 진입");
//		List<emergencyRoom> list= emergencyService.getALLBookList();
//		model.addAttribute("bookList",list);
//		return "books";
//	}
//	

	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		System.out.println("000.bc mav AllBook : 진입");
		ModelAndView modelAndView = new ModelAndView();
		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		modelAndView.addObject("bookList",list);
		modelAndView.setViewName("books");
		return modelAndView;
	}
	
	 
	
	@ModelAttribute
	public void addAttributrs(Model model) {
		model.addAttribute("addTitle","신규도서등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId","name","ubitPrice","Author","Description",
				"publisher","category","unitsInStock","totalPages",
				"releaseDate","condition","bookImage");
	}
	


	
}
