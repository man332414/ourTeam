package com.springmvc.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class HospitalListAddOpenAPI {
    public static void main(String[] args) throws IOException {
    	String key = "59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D";
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B551182/hospAsmInfoService/getHospAsmInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=59ojQNxXAJkaA29tsw%2Fql6IaRazj4K%2BUDFTTAom7HTo318eWaC99iJ9Hy761TzJ1KAyTulV2WYF4A3U0MDD8Xg%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("ykiho","UTF-8") + "=" + URLEncoder.encode("JDQ4MTg4MSM1MSMkMSMkMCMkODkkMzgxMzUxIzExIyQxIyQzIyQ4OSQyNjE4MzIjNTEjJDEjJDYjJDgz", "UTF-8")); 
        /*암호화된 요양기호(확인방법: 건강보험심사평가원 오픈API[병원정보서비스>병원기본목록(getHospBasisList1)](암호화된요양기호(ykiho)))*/
        URL url = new URL(urlBuilder.toString());
        
        System.out.println("urlBuilder  : " + urlBuilder);
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
        rd.close();
        conn.disconnect();
        System.out.println("sb.toString()= " + sb.toString());
    }
    
    public void hospital() {
    	
    }
    
    
}
