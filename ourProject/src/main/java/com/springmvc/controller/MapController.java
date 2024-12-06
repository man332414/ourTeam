package com.springmvc.controller;

import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.w3c.dom.Document;

import com.springmvc.DTO.emergencyRoom;
import com.springmvc.api.HospitalListAddOpenAPI;
import com.springmvc.service.EmergencyService;


@Controller
@RequestMapping("/map")
public class MapController {
	
	@Autowired // 컴포넌트 스캔되어야 함
	private EmergencyService emergencyService;

	
	@GetMapping
	public String requestRoomList(Model model) {
		System.out.println("000.rc : requestRoomList 진입");

		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		System.out.println("뷰이동"+list);
		model.addAttribute("emergencylist",list);
		

		return "map";
	}
		
	
	@GetMapping("/mapapi")
	public String addApiRooms(Model model)  {
		System.out.println("===============================");
		System.out.println("000.EmergencyController addapiRooms : 진입");

	try {
		System.out.println("000.EmergencyController addapiRooms  try : 진입");
		HospitalListAddOpenAPI hl = new HospitalListAddOpenAPI();
		
        List<emergencyRoom> roomList = hl.fetchHospitalData(); // API 호출하여 데이터 가져오기
        System.out.println("roomList =  " + roomList);

        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("222", "UTF-8")); /*한 페이지 결과 수*/
        
        roomList = hl.fetchHospitalData(urlBuilder.toString()); // API 호출하여 데이터 가져오기
        System.out.println("+++fetchHospitalData(urlBuilder.toString())진입 " + urlBuilder.toString());
        System.out.println("+++documentInfo =  " + roomList);

        
        // DB에 저장
        for (emergencyRoom room : roomList) {
        	System.out.println("000.rc addapiRooms  try for : 진입 db입력");
            emergencyService.setNewemergencyRoom(room);
        }

        model.addAttribute("emergencylist", roomList);
    } catch (Exception e) {
        e.printStackTrace();
    }
 		
		return "maps";

	}
	
 
}
