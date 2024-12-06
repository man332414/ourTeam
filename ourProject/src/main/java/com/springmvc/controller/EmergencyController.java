package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DTO.emergencyRoom;
import com.springmvc.api.HospitalListAddOpenAPI;
import com.springmvc.service.EmergencyService;


@Controller
@RequestMapping("/emergencys")
public class EmergencyController {
	
	@Autowired // 컴포넌트 스캔되어야 함
	private EmergencyService emergencyService;
	
	//private EmergencyValidator emergencyValidator;
	
	//@RequestMapping(value="/emergencys", method=RequestMethod.GET)
	@GetMapping
	public String requestRoomList(Model model) {
		System.out.println("000.rc : requestRoomList 진입");

		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		System.out.println("뷰이동"+list);
		model.addAttribute("emergencylist",list);
		

		return "emergencys";
	}
		
	
	@RequestMapping("/emergency")
	public String welcome(Model model) {
		model.addAttribute(model);
		return "emergency";
	}
		
	
	@GetMapping("/all")
	public ModelAndView requestAllRooms() {
		System.out.println("000.rc requestAllrooms : 진입");
		ModelAndView modelAndView = new ModelAndView();
		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		modelAndView.addObject("emergencylist",list);
		modelAndView.setViewName("emergencys");
		return modelAndView;
	}
	
	@GetMapping("/{address}")
	public String requestRoomsByAddress(@PathVariable("address") String address,Model model) {
		System.out.println("000.rc requestRoomsByAddress : 진입"+ address);
		List<emergencyRoom> roomsByAddress= emergencyService.getemergencyRoomListByAddress(address);
		
		if (roomsByAddress == null || roomsByAddress.isEmpty()){
//			throw new AddressException();
		}
		model.addAttribute("emergencylist",roomsByAddress);
		
		return "emergencys";
	} 
	
	@GetMapping("add")
	public String requestAddRoomForm(@ModelAttribute("NewRoom") emergencyRoom room) {
		System.out.println("===============================");
		System.out.println("000.rc get requestAddRoomForm : 진입");
		
		return "addRoom";
	}
	
	
	@PostMapping("/add")
	public String submitAddNewBook(@ModelAttribute("NewRoom") emergencyRoom room,BindingResult result, HttpServletRequest request){
			System.out.println("000.rc post submitAddNewBook : 진입 "+ room);
			
			if(result.hasErrors()) 
				return "addRoom";
			
			//MultipartFile bookImage = book.getBookImage();
			//String save=request.getServletContext().getRealPath("resources/images");
			//String saveName = bookImage.getOriginalFilename();
			//File savefile = new File(save,saveName);
			
//			if(bookImage != null && !bookImage.isEmpty()) {
//				try {
//					bookImage.transferTo(savefile);
//					book.setFileName(saveName);
//					
//				}catch(Exception e) {
//					throw new RuntimeException("도서 이미지 업로드가 실패했습니다:",e);
//				}
//			}
			
			emergencyService.setNewemergencyRoom(room);
			
		return "redirect:/emergencys";
	}
	
	 
	
	@GetMapping("/addapi")
	public String addApiRooms(Model model)  {
		System.out.println("===============================");
		System.out.println("000.rc addapiRooms : 진입");

	try {
		System.out.println("000.rc addapiRooms  try : 진입");
		HospitalListAddOpenAPI hl = new HospitalListAddOpenAPI();
		System.out.println("h1 =  : 진입");
        List<emergencyRoom> roomList = hl.fetchHospitalData(); // API 호출하여 데이터 가져오기
        System.out.println("roomList =  " + roomList);

        // DB에 저장
        for (emergencyRoom room : roomList) {
        	System.out.println("000.rc addapiRooms  try for : 진입");
            emergencyService.setNewemergencyRoom(room);
        }

        model.addAttribute("emergencylist", roomList);
    } catch (Exception e) {
        e.printStackTrace();
    }
//		ModelAndView modelAndView = new ModelAndView();
//		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
//		modelAndView.addObject("emergencylist",list);
//		modelAndView.setViewName("emergencys");
		
		return "hosps";
//		return "redirect:/emergencys";
	}
	
	//HospitalListAddOpenAPI
	
	 
	@ModelAttribute
	public void addAttributrs(Model model) {
		model.addAttribute("addTitle","신규병원등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("number","hosName","hosaddr","distance","travelTime",
				"numOfBad","isPediatrics","isObstetricsAndGynecology");
	}

}