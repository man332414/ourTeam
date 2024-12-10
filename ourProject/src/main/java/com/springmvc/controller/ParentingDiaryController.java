package com.springmvc.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DTO.parentingDiary;
import com.springmvc.service.ParentingDiaryService;

@Controller
@RequestMapping("/diarys")
public class ParentingDiaryController {
	
	@Autowired // 컴포넌트 스캔되어야 함
	private ParentingDiaryService parentingDiaryService;
	
	@GetMapping
	public String requestdiaryList(Model model) {
		System.out.println("=============================");
		System.out.println("000.rc : requestdiaryList 진입");

		List<parentingDiary> list= parentingDiaryService.getALLparentingDiary();
		System.out.println("뷰이동: " + list);
		model.addAttribute("diarylist",list);
		
		return "diarys";
	}
		
	@GetMapping("/diary")
	public String viewProductDetail(@RequestParam("num") int id, Model model) {
	    parentingDiary diary = parentingDiaryService.getparentingDiaryById(id); // 제품 ID로 조회
	    model.addAttribute("diary", diary); // 모델에 추가
	    return "diary"; // JSP 파일 이름
	}
	
	
	@GetMapping("/all")
	public ModelAndView requestAllLists() {
		System.out.println("000.rc requestAlldiarys : 진입");
		ModelAndView modelAndView = new ModelAndView();
		List<parentingDiary> list= parentingDiaryService.getALLparentingDiary();
		modelAndView.addObject("diarylist",list);
		modelAndView.setViewName("diarys");
		return modelAndView;
	}
	
	@GetMapping("add")
	public String requestAddDiaryForm(@ModelAttribute("NewDiary") parentingDiary diary,BindingResult result, HttpServletRequest request) {
		System.out.println("===============================");
		System.out.println("000.rc get requestAddDiaryForm : 진입");
		
		//form에 입력
		if(result.hasErrors()) 
			return "adddiary";
		
		return "addDiary";
	}
	
	
	@PostMapping("/add")
	public String submitAddNewDiary(@ModelAttribute("NewDiary") parentingDiary diary,BindingResult result, HttpServletRequest request){
			System.out.println("000.pc post submitAddNewDiary : 진입 "+ diary);
			
			if(result.hasErrors()) 
				return "addDiary";
			
			// DB에 저장
			System.out.println("DB에 저장 setNewparentingDiary : 실행 ");
			System.out.println("Weather: " + diary.getWeather());
			parentingDiaryService.setNewparentingDiary(diary);
			
		return "redirect:/diarys";
	}
	
//	@DeleteMapping("delete/{id}")
//    public ResponseEntity<Void> deleteDiary(@PathVariable int id) {
//		System.out.println("000.deleteDiary : 진입 "+ id);
//		parentingDiaryService.deleteDiary(id);
//        return ResponseEntity.noContent().build(); // 204 No Content 응답 반환
//    } 
	
	//@GetMapping("delete/{id}") ajax로 변경
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDiary(@PathVariable int id) {
		System.out.println("============================");
		System.out.println("000.deleteDiary : 진입 "+ id);
		parentingDiaryService.deleteDiary(id);
        return ResponseEntity.noContent().build(); // 204 No Content 응답 반환
    }
	
	@ModelAttribute
	public void addAttributrs(Model model) {
		model.addAttribute("addTitle","신규일기등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("id","today","weather","myMood","diaryText","fileName" );
		// 커스텀 LocalDateTime 변환기 추가
        binder.registerCustomEditor(LocalDateTime.class, "today", new CustomLocalDateTimeEditor());
	}
	
	

}
