package com.springmvc.DTO;

public class parentingDiary 
{
	long today = System.currentTimeMillis();
	String wather;
	String myMood;
	String diaryText;
	String fileName;
	
	public long getToday() {
		return today;
	}
	public void setToday(long today) {
		this.today = today;
	}
	public String getWather() {
		return wather;
	}
	public void setWather(String wather) {
		this.wather = wather;
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
