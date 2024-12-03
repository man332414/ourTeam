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
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DTO.emergencyRoom;
import com.springmvc.api.HospitalListAddOpenAPI;
import com.springmvc.service.EmergencyService;
import com.springmvc.exception.AddressException;

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
		
  //@RequestMapping(value="/rooms", method=RequestMethod.GET)
	@GetMapping
	public String requestRoomList(Model model) {
		System.out.println("000.rc : requestRoomList 진입");
		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		System.out.println("뷰이동"+list);
		model.addAttribute("emergencylist",list);
		
		return "emergencys";
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
	
	@ModelAttribute
	public void addAttributrs(Model model) {
		model.addAttribute("addTitle","신규병원등록");
	}
	
	@GetMapping("addapi")
	public ModelAndView addapiRooms() {
		System.out.println("===============================");
		System.out.println("000.rc addapiRooms : 진입");
		HospitalListAddOpenAPI hl = new HospitalListAddOpenAPI();
		 
		ModelAndView modelAndView = new ModelAndView();
		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		modelAndView.addObject("emergencylist",list);
		modelAndView.setViewName("emergencys");
		return modelAndView;
	}
	
	//HospitalListAddOpenAPI
	
	
	
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("number","hosName","hosaddr","distance","travelTime",
				"numOfBad","isPediatrics","isObstetricsAndGynecology");
	}
	
}
