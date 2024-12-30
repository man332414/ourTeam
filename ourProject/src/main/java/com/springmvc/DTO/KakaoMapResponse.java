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
            }

            @Data
            public static class Duration {
                private int value; // 시간 (초)
                private String text; // 시간 (예: "15 mins")
            }

			public AbstractStringBuilder getDistance() {
				// TODO Auto-generated method stub
				return null;
			}

			 
        }
    }

	public String getRoutes() {
		// TODO Auto-generated method stub
		String s="";
		return s;
	}

	 
}

 

