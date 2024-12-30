package com.springmvc.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.springmvc.DTO.KakaoMapResponse;
import com.springmvc.DTO.emergencyRoom;
import com.springmvc.controller.DistanceCalculator;


public class HospitalListAddOpenAPI {

	private static final String API_URL = "http://apis.data.go.kr/B551182/hospAsmInfoService/getHospAsmInfo"; // 초기화

	private StringBuilder urlBuilder;
	private BufferedReader rd;

    public   void  apimain()   {

    	try {
    	System.out.println("HospitalListAddOpenAPI 진입");
    	HospitalListAddOpenAPI hl = new HospitalListAddOpenAPI();

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospAsmInfoService/getHospAsmInfo"); /*URL*/
        //StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B551182/hospInfoServicev2/getHospBasisList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("ykiho","UTF-8") + "=" + URLEncoder.encode("JDQ4MTg4MSM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQxIyQzIyQ4OSQyNjE4MzIjNTEjJDEjJDYjJDgz", "UTF-8"));
        /*암호화된 요양기호(확인방법: 건강보험심사평가원 오픈API[병원정보서비스>병원기본목록(getHospBasisList1)](암호화된요양기호(ykiho)))*/
        URL url = new URL(urlBuilder.toString());

        System.out.println("url  : " + url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;

        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println("BufferedReader rd: " + rd);
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
        	System.out.println("line= " + line );

            sb.append(line);
        }

        this.rd = rd;
        this.urlBuilder=urlBuilder;
        rd.close();
        conn.disconnect();

		hl.hospital(urlBuilder );
    	}catch(Exception e) {}
    }

    public void hospital(StringBuilder urlBuilder) {
    	System.out.println("hospital  진입 " + urlBuilder);
    }

    public List<emergencyRoom> fetchHospitalData() {
    	System.out.println("   HospitalListAddOpenAPI fetchHospitalData:  진입 " );
    	System.out.println("    apimain()  호출 kkk" );
    	apimain();
    	urlBuilder = this.urlBuilder;
    	rd= this.rd;
    	System.out.println("rd  = " + rd);
    	System.out.println("fetchHospitalData:  urlBuilder= " + urlBuilder);

        List<emergencyRoom> roomList = new ArrayList<>();


        try {
            // API 호출
            URL url = new URL(urlBuilder.toString());
            System.out.println("fetchHospitalData: try 진입 url = " + url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");

            // API 응답 처리
            System.out.println("1.  api connection = " + connection);
        //    InputStream responseStream = connection.getInputStream()
            InputStream responseStream = connection.getInputStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            System.out.println("2.  api responseStream = " + responseStream.toString());
            System.out.println("3.  api factory = " + factory.toString());
            System.out.println("4.  api builder = " + builder.toString());

            // StreamSource를 사용하지 않고 InputStream으로 파싱

//            Document doc = builder.parse(responseStream);
//            System.out.println("5.  api doc = " + doc.toString());
//
            Document documentInfo = null;
            documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(responseStream);
            documentInfo.getDocumentElement().normalize();
            System.out.println("5.xxx  documentInfo = " + documentInfo.toString());
            //Root: HRDNet
            System.out.println("Root: " + documentInfo.getDocumentElement().getNodeName());

            //     Document doc = builder.parse(responseStream);

            // XML 파싱
            NodeList hospitalNodes = documentInfo.getElementsByTagName("hospital"); // XML에서 병원 노드 찾기

            System.out.println("6.  api hospitalNodes = " + hospitalNodes);


            for (int i = 0; i < hospitalNodes.getLength(); i++) {
                Element hospitalElement = (Element) hospitalNodes.item(i);
                emergencyRoom room = new emergencyRoom();

                room.setHosName(hospitalElement.getElementsByTagName("name").item(i).getTextContent());
                room.setHosaddr(hospitalElement.getElementsByTagName("address").item(i).getTextContent());
                room.setPediatrics(Boolean.parseBoolean(hospitalElement.getElementsByTagName("isPediatrics").item(0).getTextContent()));
                room.setObstetricsAndGynecology(Boolean.parseBoolean(hospitalElement.getElementsByTagName("isObstetricsAndGynecology").item(0).getTextContent()));

                room.setDistance(1);
                room.setTravelTime(API_URL);

                roomList.add(room);
            }

            responseStream.close(); // InputStream 닫기
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fetchHospitalData:  roomList= " + roomList);
        return roomList;
    }


    public List<emergencyRoom> fetchHospitalData(String apiUrl) throws Exception {
    	List<emergencyRoom> roomList = new ArrayList<>();
    	double homeXPos = 35.232058;
    	double homeYPos = 128.583789;

    	System.out.println("10. fetchHospitalData:  진입 " );
    	System.out.println("11. apiUrl=  " + apiUrl);
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // 응답 코드 체크
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        // BufferedReader로 응답 읽기
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();

     // XML 자료를 출력
        String xmlData = sb.toString();

     //   System.out.println(xmlData); // XML 자료 출력

        // StringReader로 XML 자료 읽기
        StringReader stringReader = new StringReader(xmlData);
        InputSource inputSource = new InputSource(stringReader);

        // XML 파싱
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document documentInfo = builder.parse(inputSource);

        // XML에서 데이터 추출
        NodeList hospitalNodes = documentInfo.getElementsByTagName("item"); // <item> 요소 찾기

        // 각 <item> 요소를 순회하며 데이터 출력
        System.out.println("================================= xHospital Name: for 문 진입" );
        for (int i = 0; i < hospitalNodes.getLength(); i++) {
            Element hospitalElement = (Element) hospitalNodes.item(i);

            // 필요한 데이터 추출 (예: <name>, <address> 등)
            String name = hospitalElement.getElementsByTagName("yadmNm").item(0).getTextContent(); // <name> 요소

            String address = hospitalElement.getElementsByTagName("addr").item(0).getTextContent(); // <address> 요소
            String xPOS = hospitalElement.getElementsByTagName("YPos").item(0).getTextContent(); // <address> 요소
            String yPOS = hospitalElement.getElementsByTagName("XPos").item(0).getTextContent(); // <address> 요소

            // 데이터 출력
//            System.out.println("Hospital Name: " + name);
//            System.out.println("Hospital Address: " + address);
            System.out.println("x 좌표: " + xPOS);

            System.out.println("y 좌표: " + yPOS);
//            System.out.println("---------------------------");
//
            hospitalElement = (Element) hospitalNodes.item(i);
            emergencyRoom room = new emergencyRoom();
            DistanceCalculator dis = new DistanceCalculator();

            double dismeter = dis.distance(35.232058,128.583789,Double.parseDouble(xPOS), Double.parseDouble(yPOS));
            System.out.println("dismeter= " + dismeter);

         // 카카오맵 API를 통해 거리 및 시간 계산
            double distance = getDistanceAndTime(homeXPos, homeYPos, Double.parseDouble(xPOS), Double.parseDouble(yPOS));

            
            room.setHosName(name);
            room.setHosaddr(address);

            room.setDistance((int)dismeter);
            room.setTravelTime("00:30:00");
            room.setDistance((int) distance);
            room.setTravelTime("00:30:00"); // 실제 이동 시간을 카카오 API에서 받아올 수 있도록 수정 필요

            room.setPediatrics(true);
            room.setObstetricsAndGynecology(false);
            room.setLatitude(Double.parseDouble(xPOS));
            room.setLongitude(Double.parseDouble(yPOS));

            roomList.add(room);

        }

        return roomList;

    	}
    
    private double getDistanceAndTime(double originLat, double originLon, double destLat, double destLon) {
    	
    	String kakaoApiKey ="d5934fbf6c46e7c57da3924560a75db6";
        
    	try {
            String url = String.format("https://apis.kakao.com/v2/maps/directions.json?origin=%s,%s&destination=%s,%s",
                    originLon, originLat, destLon, destLat);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "KakaoAK " + kakaoApiKey);

            HttpEntity<String> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<KakaoMapResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, KakaoMapResponse.class);

            if (response.getBody() != null && response.getBody().getRoutes().length > 0) {
                KakaoMapResponse.Route.Leg leg = response.getRoutes()[0].getLegs()[0];
                return leg.getDistance().getValue(); // 거리(m)
                // 이동 시간은 추가로 필요한 경우 반환할 수 있음
              
            }
        } catch (Exception e) {
            System.err.println("Error fetching distance and time: " + e.getMessage());
        }
        return 0; // 기본값
    }
    
    
}
