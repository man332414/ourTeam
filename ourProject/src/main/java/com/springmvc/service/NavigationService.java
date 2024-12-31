package com.springmvc.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NavigationService {

    private final String clientId = "4hv51h0bie"; // 직접 입력한 API 키
    private final String clientSecret = "LCQ3zKx3buM8r0GKeaFPXVA0FJxq7XXtU4ViZqZf"; // 직접 입력한 비밀 키
    
	//private final String clientId = "fT8cGc35ZB"; // 직접 입력한 비밀 키
    //private final String clientSecret = "v6isiUY6Gf_HkL7Frwur"; // 직접 입력한 API 키
   // private final String clientSecret = "fT8cGc35ZB"; // 직접 입력한 비밀 키

    public String getDistanceAndTime(String start, String destination) {
        System.out.println("===========================");
        System.out.println("10000. getDistanceAndTime 진입");
        String url = "https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving";

        String requestUrl = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("start", start)
                .queryParam("goal", destination)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
        headers.set("X-NCP-APIGW-API-KEY", clientSecret);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println("11. HttpEntity entity= "+ entity);

        ResponseEntity<String> response;
        System.out.println("12. ResponseEntity response= ");
        try {
        	System.out.println("13. try 진입  ");
        	
            response = restTemplate.exchange(requestUrl, HttpMethod.GET, entity, String.class);
            System.out.println("13-1. restTemplate response= "+ response);
        } catch (HttpClientErrorException e) {
            System.err.println("HTTP 오류: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return "HTTP Error: " + e.getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("13-e. Exception e= "+ e);
            return "Error during API call";
        }

        try {
        	System.out.println("14. try 진입");
            JSONObject jsonResponse = new JSONObject(response.getBody());
            System.out.println("15. JSONObject jsonResponse = " + jsonResponse);
            double distance = jsonResponse.getJSONObject("route").getJSONObject("traoptimal").getDouble("distance") / 1000; // km 단위
            String travelTime = jsonResponse.getJSONObject("route").getJSONObject("traoptimal").getString("summary");

            System.out.println("distance = " + distance);
            System.out.println("==== travelTime = " + travelTime);
            return travelTime;
        } catch (Exception e) {
            System.err.println("JSON 파싱 오류: " + e.getMessage());
            return "Error parsing JSON response";
        }
    }
}