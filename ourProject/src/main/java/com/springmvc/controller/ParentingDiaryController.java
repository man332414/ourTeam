package com.springmvc.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DTO.parentingDiary;
import com.springmvc.service.ParentingDiaryService;

@Controller
@RequestMapping("/diarys")
public class ParentingDiaryController {

	@Autowired // 컴포넌트 스캔되어야 함
	private ParentingDiaryService parentingDiaryService;

	@GetMapping
	public String requestdiaryList(Model model, @RequestParam String userId) {
		System.out.println("=============================");
		System.out.println("000.rc : requestdiaryList 진입");

		List<parentingDiary> list= parentingDiaryService.getALLparentingDiary(userId);
		System.out.println("뷰이동: " + list);
		model.addAttribute("diarylist",list);

		return "readAllDiarys";
	}

	@GetMapping("/all")
	public ModelAndView requestAllLists(@RequestParam String userId) {
		System.out.println("000.rc requestAlldiarys : 진입");
		ModelAndView modelAndView = new ModelAndView();
		List<parentingDiary> list= parentingDiaryService.getALLparentingDiary(userId);
		modelAndView.addObject("diarylist",list);
		modelAndView.setViewName("diarys");
		return modelAndView;
	}

	@GetMapping("/add")
	public String requestAddDiaryForm(@ModelAttribute("NewDiary") parentingDiary Diary,BindingResult result, HttpServletRequest request) {
		System.out.println("===============================");
		System.out.println("000.rc get requestAddDiaryForm : 진입");

		//form에 입력
		if(result.hasErrors()) {
			return "createDiary";
		}

		return "createDiary";
	}


	@PostMapping("/add")
	public String submitAddNewDiary(@ModelAttribute("NewDiary") parentingDiary diary, BindingResult result, HttpServletRequest request) {
	    System.out.println("000.pc post submitAddNewDiary : 진입 " + diary);

	    if (result.hasErrors()) {
	        return "createDiary"; // 유효성 검사 실패 시 폼으로 리턴
	    }
	    
	    System.out.println("diary.getUserId() " + diary.getUserId());
	    System.out.println("diary.getMymood() " + diary.getMyMood());

	    MultipartFile diaryImage = diary.getDiaryImage();
	    System.out.println("003.pc post submitAddNewDiary : diaryImage= " + diaryImage);
	    System.out.println("diaryImage getOriginalfileName()" + diaryImage.getOriginalFilename().isEmpty());
	    // 파일이 선택되었는지 확인
	    if (!diaryImage.getOriginalFilename().isEmpty())
	    {
	        System.out.println("파일이 업로드되지 않았습니다.");
	        request.setAttribute("errorMessage", "파일을 선택해 주세요."); // 사용자에게 알림

		    String save = request.getServletContext().getRealPath("resources/images");
		    String fileName = diaryImage.getOriginalFilename();
		    System.out.println("004.pc post submitAddNewDiary : fileName= " + fileName);
	
		    File savefile = new File(save, fileName);
		    System.out.println("009.pc post submitAddNewDiary : savefile= " + savefile);
	
		    // 파일 처리 로직
		    try {
		        diaryImage.transferTo(savefile); // 실제 파일 저장
		        diary.setFileName(fileName); // 파일 이름 설정
		        System.out.println("020.pc post submitAddNewDiary : fileName= " + fileName);
		    } catch (Exception e) {
		        e.printStackTrace();
		        request.setAttribute("errorMessage", "파일 저장 중 오류가 발생했습니다.");
		        return "createDiary"; // 오류 발생 시 폼으로 리턴
		    }
	
		    // DB에 저장
		    if (diary.getFileName() == null) {
		        System.out.println("fileName이 null입니다. 파일이 제대로 저장되지 않았습니다.");
		    } else {
		        System.out.println("DB에 저장할 fileName: " + diary.getFileName());
		    }
	    }

	    parentingDiaryService.setNewparentingDiary(diary);

	    return "redirect:/diarys?userId="+diary.getUserId(); // 성공 후 리다이렉트
	}

	@GetMapping("/{id}")
	public String viewDiaryDetail(@PathVariable int id, Model model) {
		System.out.println("ParentingDiaryController  viewDiaryDetail(): {id}진입");
	    parentingDiary diary = parentingDiaryService.getparentingDiaryById(id);
	    model.addAttribute("diary", diary);
	    return "readOneDiary"; // diary.jsp 파일 이름
	}

	@GetMapping("/update")
    public String getUpdateDiaryForm(@ModelAttribute("updateDiary") parentingDiary diary, @RequestParam("id") int id, Model model) {
		parentingDiary diaryById = parentingDiaryService.getparentingDiaryById(id);
        model.addAttribute("diary", diaryById);
        return "updateDaily";  // 수정 폼
    }

	@PostMapping("/update")
    public String submitUpdateDiaryForm(@ModelAttribute("updateDiary") parentingDiary diary) {
        MultipartFile diaryImage = diary.getDiaryImage();
        String rootDirectory = "c:/upload/";
        if (diaryImage!=null && !diaryImage.isEmpty()) {
            try {
                String fname = diaryImage.getOriginalFilename();
                diaryImage.transferTo(new File(rootDirectory + fname));
                diary.setFileName(fname);
            } catch (Exception e) {
                throw new RuntimeException("Book Image saving failed", e);
            }
        }

        parentingDiaryService.setUpdateparentingDiary(diary);
        return "redirect:./"+diary.getId();
    }

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
		binder.setAllowedFields("id","today","weather","myMood","diaryText","fileName","diaryImage", "userId");
		// 커스텀 LocalDateTime 변환기 추가
        binder.registerCustomEditor(LocalDateTime.class, "today", new CustomLocalDateTimeEditor());
	}



}
