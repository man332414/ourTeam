package com.springmvc.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import com.springmvc.DTO.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class HospitalListAddOpenAPI {
	
	private static final String API_URL = "http://apis.data.go.kr/B551182/hospAsmInfoService/getHospAsmInfo"; // 초기화
    
	private StringBuilder urlBuilder;
	private BufferedReader rd;
	
    public   void  apimain()   {

    	try {
    	System.out.println("HospitalListAddOpenAPI 진입");
    	HospitalListAddOpenAPI hl = new HospitalListAddOpenAPI();
    	
    	String key = "59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D";
//        
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospAsmInfoService/getHospAsmInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
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
        System.out.println("sb.toString()= " + sb.toString());
        
		hl.hospital(urlBuilder );
    	}catch(Exception e) {}
    }
    
    public void hospital(StringBuilder urlBuilder) {
    	System.out.println("hospital  진입 " + urlBuilder);
    }
    
    public List<emergencyRoom> fetchHospitalData() {
    	System.out.println("fetchHospitalData:  진입 " );
    	System.out.println("apimain()  호출 kkk" );
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
            
            Document doc = builder.parse(responseStream); 
            
            //     Document doc = builder.parse(responseStream);
            System.out.println("5.  api doc = " + doc.toString());
            
            // XML 파싱
            NodeList hospitalNodes = doc.getElementsByTagName("hospital"); // XML에서 병원 노드 찾기
            
            System.out.println("5.  api hospitalNodes = " + hospitalNodes);

            for (int i = 0; i < hospitalNodes.getLength(); i++) {
                Element hospitalElement = (Element) hospitalNodes.item(i);
                emergencyRoom room = new emergencyRoom();

                room.setHosName(hospitalElement.getElementsByTagName("name").item(0).getTextContent());
                room.setHosaddr(hospitalElement.getElementsByTagName("address").item(0).getTextContent());
                room.setPediatrics(Boolean.parseBoolean(hospitalElement.getElementsByTagName("isPediatrics").item(0).getTextContent()));
                room.setObstetricsAndGynecology(Boolean.parseBoolean(hospitalElement.getElementsByTagName("isObstetricsAndGynecology").item(0).getTextContent()));

                roomList.add(room);
            }

            responseStream.close(); // InputStream 닫기
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fetchHospitalData:  roomList= " + roomList);
        return roomList;
    }
    
    
    
}