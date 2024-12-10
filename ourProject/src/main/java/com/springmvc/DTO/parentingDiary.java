package com.springmvc.DTO;

import java.time.LocalDateTime;

public class parentingDiary 
{
	//long today = System.currentTimeMillis();  //날자
	private int id ;             //key
	private LocalDateTime today; // 또는 Date 타입
	private String weather;    //날씨
	private String myMood;     //기분 또는 상태
	private String diaryText;  //내용
	private String fileName;   //사진첨무
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getToday() {
		return today;
	}
	public void setToday(LocalDateTime today) {
		this.today = today;
	}
	
	public String getWeather() {
		System.out.println("getWeather := " + weather);
		return weather;
	}
	public void setWeather(String weather) {
		System.out.println("setWeather : " + weather);
		this.weather = weather;
	}
	public String getMyMood() {
		return myMood;
	}
	public void setMyMood(String myMood) {
		this.myMood = myMood;
	}
	public String getDiaryText() {
		return diaryText;
	}
	public void setDiaryText(String diaryText) {
		this.diaryText = diaryText;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
		 
}
