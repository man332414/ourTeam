package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
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
import org.w3c.dom.Document;

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
		System.out.println("000.EmergencyController addapiRooms : 진입");

	try {
		System.out.println("000.EmergencyController addapiRooms  try : 진입");
		HospitalListAddOpenAPI hl = new HospitalListAddOpenAPI();
		
        List<emergencyRoom> roomList = hl.fetchHospitalData(); // API 호출하여 데이터 가져오기
        System.out.println("roomList =  " + roomList);

        Document documentInfo = null;
        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")); /*한 페이지 결과 수*/
        URL url = new URL(urlBuilder.toString());
        
        roomList = hl.fetchHospitalData(urlBuilder.toString()); // API 호출하여 데이터 가져오기
        System.out.println("+++fetchHospitalData(urlBuilder.toString())진입 " + urlBuilder.toString());
        System.out.println("+++documentInfo =  " + roomList);

        
        // DB에 저장
        for (emergencyRoom room : roomList) {
        	//System.out.println("000.rc addapiRooms  try for : 진입 db입력");
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
