package com.springmvc.controller;

import java.awt.geom.Point2D;

public class DistanceCalculator {

    public double distance(double startlat,double startlon,double endlat,double endlon, String unit) {
        // 서울의 좌표
        Point2D start = new Point2D.Double(startlat, startlon);

        // 부산의 좌표
        Point2D end = new Point2D.Double(endlat, endlon);

        // 두 지점 간의 거리 계산
        double distance = start.distance(end);

        
        double theta = startlon - endlon;
		double dist = Math.sin(deg2rad(startlat)) * Math.sin(deg2rad(endlat)) + Math.cos(deg2rad(startlat)) * Math.cos(deg2rad(endlat)) * Math.cos(deg2rad(theta));
		
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		
		if (unit == "kilometer") {
			dist = dist * 1.609344;
		} else if(unit == "meter"){
			dist = dist * 1609.344;
		} 

        
		return (dist);
	}
	

	// This function converts decimal degrees to radians
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	// This function converts radians to decimal degrees
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

  
}