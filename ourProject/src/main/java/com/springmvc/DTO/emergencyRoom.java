package com.springmvc.DTO;

public class emergencyRoom 
{
	private int number;
	private String hosName;
	private String hosaddr;
	private int distance;
	private String travelTime;
	private int numOfBad;
	private boolean isPediatrics;
	private boolean isObstetricsAndGynecology;
	
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
