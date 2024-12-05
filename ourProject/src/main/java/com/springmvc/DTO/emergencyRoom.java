package com.springmvc.DTO;

public class emergencyRoom 
{
	int number;            //순번
	String hosName;        //병원이름
	String hosaddr;        //병원주소
	int distance;          //거리
	String travelTime;     //이동시간
	int numOfBad;          //응급실병상수
	boolean isPediatrics;  //소아과보유여부
	boolean isObstetricsAndGynecology;    //산부인과보유여부
	
	public emergencyRoom() {}
	
	public emergencyRoom(int number) {
		this.number = number;
	}
	
	public emergencyRoom(int number,String hosName,String hosaddr) {
		this.number = number;
		this.hosName = hosName;
		this.hosaddr = hosaddr;
	}
	
	 
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getHosName() {
		return hosName;
	}
	public void setHosName(String hosName) {
		this.hosName = hosName;
	}
	public String getHosaddr() {
		return hosaddr;
	}
	public void setHosaddr(String hosaddr) {
		this.hosaddr = hosaddr;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public int getNumOfBad() {
		return numOfBad;
	}
	public void setNumOfBad(int numOfBad) {
		this.numOfBad = numOfBad;
	}

	public boolean isPediatrics() {
		return isPediatrics;
	}

	public void setPediatrics(boolean isPediatrics) {
		this.isPediatrics = isPediatrics;
	}

	public boolean isObstetricsAndGynecology() {
		return isObstetricsAndGynecology;
	}

	public void setObstetricsAndGynecology(boolean isObstetricsAndGynecology) {
		this.isObstetricsAndGynecology = isObstetricsAndGynecology;
	}
	 
	
}
