package com.springmvc.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class mapapiDisTime {
    
    @JsonProperty("routes")
    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public static class Route {
        @JsonProperty("distance")
        private int distance; // 거리 (미터)
        
        @JsonProperty("duration")
        private int duration; // 시간 (초)

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
    }
}