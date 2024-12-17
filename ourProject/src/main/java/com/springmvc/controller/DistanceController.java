package com.springmvc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

    // POST 요청을 받아 거리를 계산하고 결과를 반환하는 메서드
    @PostMapping("/calculate-distance")
    public String calculateDistance(@RequestBody Location location1, @RequestBody Location location2) {
        // 두 지점 간의 거리 계산
        double distance = calculateDistanceInMeters(location1, location2);

        // 결과 문자열 반환
        return String.format("Distance between the two locations: %.2f meters", distance);
    }

    // 두 지점 간의 거리를 미터로 계산하는 메서드
    private double calculateDistanceInMeters(Location location1, Location location2) {
        // 위도 및 경도를 라디안으로 변환
        double lat1 = Math.toRadians(location1.getLatitude());
        double lon1 = Math.toRadians(location1.getLongitude());
        double lat2 = Math.toRadians(location2.getLatitude());
        double lon2 = Math.toRadians(location2.getLongitude());

        // Haversine 공식을 사용하여 두 지점 간의 거리 계산
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // 지구의 반지름 (미터 단위)
        double radius = 6371000.0;

        // 최종 거리 계산
        return radius * c;
    }
}