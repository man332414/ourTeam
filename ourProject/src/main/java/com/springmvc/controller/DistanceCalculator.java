package com.springmvc.controller;

import java.awt.geom.Point2D;

public class DistanceCalculator {

    public double distance(double startlat,double startlon,double endlat,double endlon) {
        // 서울의 좌표
        Point2D start = new Point2D.Double(startlat, startlon);

        // 부산의 좌표
        Point2D end = new Point2D.Double(endlat, endlon);

        // 두 지점 간의 거리 계산
        double distance = start.distance(end);

        // 결과 출력
        System.out.printf("Distance between start and end: %.2f meters", distance*100);
        System.out.println(" " );
        System.out.println("start lat= "+ startlat+"start lon= "+ startlon);
        System.out.println("end lat= "+ endlat+"end lon= "+ endlon);

        // 서울시청의 좌표
        Point2D seoul = new Point2D.Double(37.5665, 126.9780);

        // 부산시청의 좌표
        Point2D busan = new Point2D.Double(35.1796, 129.0756);

        // 두 지점 간의 거리 계산
        double distance2 = seoul.distance(busan);

        // 결과 출력
        System.out.printf("Distance between Seoul and Busan: %.2f kilometers", distance2*100);

        return distance;

    }

}