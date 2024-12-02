package com.springmvc.DTO;

public class parentingDiary 
{
	private long today = System.currentTimeMillis();
	private String wather;
	private String myMood;
	private String diaryText;
	private String fileName;
	
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
