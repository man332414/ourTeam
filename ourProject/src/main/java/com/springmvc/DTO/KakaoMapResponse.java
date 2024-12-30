package com.springmvc.DTO;

import lombok.Data;

@Data
public class KakaoMapResponse {
    private Route[] routes;

    @Data
    public static class Route {
        private Leg[] legs;

        @Data
        public static class Leg {
            private Distance distance;
            private Duration duration;

            @Data
            public static class Distance {
                private int value; // 거리 (미터)
                private String text; // 거리 (예: "12.3 km")

                // 거리 정보를 반환하도록 수정
                public String getText() {
                    return text; // null이 아닌 실제 거리 값을 반환
                }
            }

            @Data
            public static class Duration {
                private int value; // 시간 (초)
                private String text; // 시간 (예: "15 mins")
				public String getText() {
					// TODO Auto-generated method stub
					return text;
				}
            }
            
            // 거리 정보를 문자열로 반환
            public String getDistance() {
                return distance != null ? distance.getText() : "거리 정보 없음";
            }

            @Override
            public String toString() {
                return "Leg{" +
                        "distance=" + (distance != null ? distance.getText() : "거리 정보 없음") +
                        ", duration=" + (duration != null ? duration.getText() : "시간 정보 없음") +
                        '}';
            }
        }

        @Override
        public String toString() {
            StringBuilder legsInfo = new StringBuilder();
            if (legs != null) {
                for (Leg leg : legs) {
                    legsInfo.append(leg.toString()).append("\n");
                }
            }
            return "Route{" + "legs=\n" + legsInfo.toString() + '}';
        }
    }

    // routes 정보를 문자열로 반환
    public String getRoutes() {
        StringBuilder routesInfo = new StringBuilder();
        if (routes != null) {
            for (Route route : routes) {
                routesInfo.append(route.toString()).append("\n");
            }
        }
        return routesInfo.toString();
    }
}