package com.springmvc.controller;

import java.net.URLEncoder;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.DTO.emergencyRoom;
import com.springmvc.api.HospitalListAddOpenAPI;
import com.springmvc.service.EmergencyService;

@Controller
//@RequestMapping("/map")
public class MapController {

	@Autowired // 컴포넌트 스캔되어야 함
	private EmergencyService emergencyService;
	 @Autowired
    private RestTemplate restTemplate; // XML에서 등록한 RestTemplate 빈 주입

	@GetMapping("/maptest")
    public ModelAndView showMap() {
        ModelAndView modelAndView = new ModelAndView("maptest");
        return modelAndView;
    }

	@GetMapping("/mapdistim")
	public String requestMapDisTim(Model model) {
		System.out.println("000.mapc : requestMapDisTim 진입");

		return "mapdistim";
	}

	@GetMapping("/getCoordinates")
    @ResponseBody
    public String getCoordinates(@RequestParam(required = false, defaultValue = "경남 창원시 마산회원구 양덕북12길 113") String address) {

	    System.out.println("받은 주소: " + address); // 주소 출력
	    if (address == null || address.isEmpty()) {
	        return "{\"error\": \"주소가 비어 있습니다.\"}"; // 주소가 비어 있을 경우 에러 처리
	    }


        try {
        	System.out.println("100 getCoordinates: try 진입");
            // 주소를 URL 인코딩
            String encodedAddress = URLEncoder.encode(address, "UTF-8");
            System.out.println("109 encodedAddress= " + address);
//            String apiKey = "9c0a4381f5a94e6cb0eef56dbcf98cb6"; // 실제 API 키
            String apiKey = "d5934fbf6c46e7c57da3924560a75db6"; // 실제 REST API 키
            String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + encodedAddress;
            System.out.println("110 url= " + url);
          //  url = url+ "&apiKey=" + apiKey;


            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "KakaoAK " + apiKey);
            headers.set("os", "web"); // 추가된 헤더
            headers.set("origin", "http://localhost:8080"); // 도메인 변경
          //  url = url+ "&headers=" + headers;
            System.out.println("120 headers= " + headers);

            HttpEntity<String> entity = new HttpEntity<>(headers);
            System.out.println("130 entity= " + entity);


            System.out.println("139  url= " + url);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            System.out.println("140 response= " + response);

            JSONObject jsonObject = new JSONObject(response.getBody());
            System.out.println("200 jsonObject: = "+jsonObject);

            JSONArray documents = jsonObject.getJSONArray("documents");
            System.out.println("210 documents= "+ documents);
            if (documents.length() > 0) {
                JSONObject location = documents.getJSONObject(0).getJSONObject("address");
                double latitude = location.getDouble("y");
                double longitude = location.getDouble("x");
                System.out.println("documents.length()= " + documents.length()  );
                System.out.println("latitude= " + latitude + ", longitude= " + longitude);
                return "{\"latitude\": " + latitude + ", \"longitude\": " + longitude + "}";
            } else {
                System.out.println("latitude: 0, longitude: 0");
                return "{\"latitude\": 0, \"longitude\": 0}"; // 주소가 없을 경우
            }
        } catch (Exception e) {
            System.out.println("900 Exception: error");
            e.printStackTrace();
            return "{\"error\": \"주소 검색 중 오류 발생\"}"; // 오류 발생 시 메시지 반환
        }
    }


	@GetMapping("/map")
	public String requestMap(Model model) {
		System.out.println("000.mapc : requestMap 진입");

		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		System.out.println("뷰이동"+list);
		model.addAttribute("emergencylist",list);

		return "map";
	}
	@GetMapping("/map1")
	public String requestMap1(Model model) {
		System.out.println("000.map1 : requestMap 진입");

		List<emergencyRoom> list= emergencyService.getALLemergencyRoomList();
		System.out.println("뷰이동"+list);
		model.addAttribute("emergencylist",list);

		return "map1";
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
