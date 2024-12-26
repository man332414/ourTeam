package com.springmvc.controller;

public class Location {
    private double latitude; // 위도
    private double longitude; // 경도

    // 기본 생성자
    public Location() {
        // 기본 생성자
    }

    // 매개변수를 받는 생성자
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


}
