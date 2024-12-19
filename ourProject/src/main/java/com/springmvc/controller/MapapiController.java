package com.springmvc.controller;

import com.springmvc.controller.KakaoRouteResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

	@RestController
	public class MapapiController {

	    @Value("${kakao.api.key}")
	    private String kakaoApiKey;

	    @GetMapping("/distance")
	    public ResponseEntity<KakaoRouteResponse> getDistance(@RequestParam String start, @RequestParam String end) {
	    	System.out.println("000 kakaomap getDistance 진입 " + kakaoApiKey);
	        String url = String.format("https://apis.kakao.com/v1/route?origin=%s&destination=%s", start, end);
	        System.out.println("100 url= " + url);
	        
	        RestTemplate restTemplate = new RestTemplate();
	        System.out.println("200 restTemplate= " + restTemplate);
	        System.out.println("200 restTemplate= " + restTemplate);
	        restTemplate.getInterceptors().add((request, body, execution) -> {
	            request.getHeaders().add("Authorization", "KakaoAK " + "c90c1da07d750b4cb2f9958d594fae60");
	            return execution.execute(request, body);
	        });

	        System.out.println("300 restTemplate 실행"  );
	        try {
	            KakaoRouteResponse response = restTemplate.getForObject(url, KakaoRouteResponse.class);
	            return ResponseEntity.ok(response);
	        } catch (ResourceAccessException e) {
	            System.err.println("Error accessing the API: " + e.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        } catch (Exception e) {
	            System.err.println("An unexpected error occurred: " + e.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	        }
	        
	    }
	}
	
