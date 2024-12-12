package com.springmvc.controller;

import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import com.springmvc.DTO.emergencyRoom;
import com.springmvc.api.HospitalListAddOpenAPI;
import com.springmvc.service.EmergencyService;
import org.springframework.web.client.RestTemplate;

@Controller
//@RequestMapping("/map")
public class MapController {
	
	@Autowired // 컴포넌트 스캔되어야 함
	private EmergencyService emergencyService;

	@GetMapping("/maptest")
    public ModelAndView showMap() {
        ModelAndView modelAndView = new ModelAndView("maptest");
        return modelAndView;
    }

	@GetMapping("/getCoordinates")
	@ResponseBody
	public String getCoordinates(@RequestParam String address) {
	    try {
	        // 주소를 URL 인코딩
	        String encodedAddress = URLEncoder.encode(address, "UTF-8");
	        String apiKey = "9c0a4381f5a94e6cb0eef56dbcf98cb6";
	        String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + encodedAddress;

	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "KakaoAK " + apiKey);
	        HttpEntity<String> entity = new HttpEntity<>(headers);

	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	        JSONObject jsonObject = new JSONObject(response.getBody());

	        JSONArray documents = jsonObject.getJSONArray("documents");
	        if (documents.length() > 0) {
	            JSONObject location = documents.getJSONObject(0).getJSONObject("address");
	            double latitude = location.getDouble("y");
	            double longitude = location.getDouble("x");
	            return "{\"latitude\": " + latitude + ", \"longitude\": " + longitude + "}";
	        } else {
	            return "{\"latitude\": 0, \"longitude\": 0}"; // 주소가 없을 경우
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "{\"latitude\": 0, \"longitude\": 0}"; // 오류 발생 시 기본값 반환
	    }
	}
    
	
	@GetMapping
	public String requestMap(Model model) {
		System.out.println("000.mapc : requestMap 진입");

		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		System.out.println("뷰이동"+list);
		model.addAttribute("emergencylist",list);
		
		return "map";
	}
		
//	@GetMapping("/maptest")
//	public String requestMapTest(Model model) {
//		System.out.println("000.mapc : requestMapTest 진입");
// 
//		return "maptest";
//	}
	
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
