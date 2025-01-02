package com.springmvc.service;

import org.json.JSONArray;
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
    
    public String getDistanceAndTime(String start, String destination) {
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

        ResponseEntity<String> response;
        try {
        	response = restTemplate.exchange(requestUrl, HttpMethod.GET, entity, String.class);
        } catch (HttpClientErrorException e) {
            System.err.println("HTTP 오류: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return "HTTP Error: " + e.getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("13-e. Exception e= "+ e);
            return "Error during API call";
        }

        try {
        	JSONObject jsonResponse = new JSONObject(response.getBody());
            if (jsonResponse.getInt("code") != 0) {
                return "Error: " + jsonResponse.getString("message");
            }

            JSONArray traoptimalArray = jsonResponse.getJSONObject("route").getJSONArray("traoptimal");
            if (traoptimalArray.length() > 0) {
                JSONObject traoptimal = traoptimalArray.getJSONObject(0);
                double distance = traoptimal.getJSONObject("summary").getDouble("distance") / 1000; // km 단위
                long duration = traoptimal.getJSONObject("summary").getLong("duration")/1000; // 초 단위

                // 시간 변환
                long hours = duration / 3600;
                long minutes = (duration % 3600) / 60;
                long seconds = duration % 60;

                String travelTime = String.format("%02d:%02d:%02d", hours, minutes, seconds); // HH:MM:SS 형식

                return travelTime;
            } else {
                return "Error: No traoptimal data found";
            }
        } catch (Exception e) {
            System.err.println("JSON 파싱 오류: " + e.getMessage());
            return "Error parsing JSON response";
        }
    }
}